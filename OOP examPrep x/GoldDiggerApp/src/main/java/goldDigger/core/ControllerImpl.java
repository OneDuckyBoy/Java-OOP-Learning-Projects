package goldDigger.core;

import goldDigger.models.discoverer.Anthropologist;
import goldDigger.models.discoverer.Archaeologist;
import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.discoverer.Geologist;
import goldDigger.models.operation.Operation;
import goldDigger.models.operation.OperationImpl;
import goldDigger.models.spot.Spot;
import goldDigger.models.spot.SpotImpl;
import goldDigger.repositories.DiscovererRepository;
import goldDigger.repositories.SpotRepository;

import javax.swing.*;
import java.util.*;

public class ControllerImpl implements Controller{

    private DiscovererRepository discovererRepository;
    private SpotRepository spotRepository;

    private int InspectedSpotsCount;
    public ControllerImpl() {
        discovererRepository = new DiscovererRepository();
        spotRepository = new SpotRepository();
        InspectedSpotsCount =0;
    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {
        Discoverer discoverer;
        switch (kind){
            case "Anthropologist":
                discoverer = new Anthropologist(discovererName);
                break;
            case "Archaeologist":
                discoverer = new Archaeologist(discovererName);
                break;
            case "Geologist":
                discoverer = new Geologist(discovererName);
                break;
            default:
                throw new IllegalArgumentException("Discoverer kind doesn't exists.");
        }

        discovererRepository.add(discoverer);


        return String.format("Added %s: %s.",kind,discovererName);
    }

    @Override
    public String addSpot(String spotName, String... exhibits) {
        Spot spot = new SpotImpl(spotName);

        spot.setExhibits(exhibits);

        spotRepository.add(spot);
        return String.format("Added spot: %s.",spotName);

    }

    @Override
    public String excludeDiscoverer(String discovererName) {
        Discoverer discoverer = discovererRepository.byName(discovererName);
        //discovererRepository.remove(discoverer);

        if (!discovererRepository.remove(discoverer)){
            throw new IllegalArgumentException(String.format("Discoverer %s doesn't exists.",discovererName));
        }

        return String.format("Discoverer %s has excluded!", discovererName);
    }

    @Override
    public String inspectSpot(String spotName) {

        Collection<Discoverer> discoverersReady = new ArrayList<>();
        boolean canGo = false;
        for (Object discoverer : discovererRepository.getCollection()) {
            Discoverer disk = (Discoverer) discoverer;
            if (disk.getEnergy()>45){
                discoverersReady.add(disk);
                canGo = true;
            }
        }
        if (!canGo){
            throw new IllegalArgumentException("You must have at least one discoverer to inspect the spot.");
        }
        int startNumOfDisk= discoverersReady.size();
        Operation operation = new OperationImpl();
        Spot spot = spotRepository.byName(spotName);

        int startNumOfExhibits = spot.getExhibits().size();

        operation.startOperation(spot,discoverersReady);
        int endNumOfDisk= discoverersReady.size();
        int excludedDiscoverer = startNumOfDisk-endNumOfDisk;

        int endNumOfExhibits = spot.getExhibits().size();
        InspectedSpotsCount += startNumOfExhibits-endNumOfExhibits;
        return String.format("The spot %s was inspected. %d discoverers have been excluded on this operation.",spotName,excludedDiscoverer);
    }

    @Override
    public String getStatistics() {

        StringBuilder sb = new StringBuilder();


        return null;
    }
}
