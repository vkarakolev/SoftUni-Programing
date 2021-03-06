package SpaceStation.core;

import SpaceStation.models.astronauts.*;
import SpaceStation.models.mission.*;
import SpaceStation.models.planets.*;
import SpaceStation.repositories.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static SpaceStation.common.ConstantMessages.*;
import static SpaceStation.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Astronaut> astronauts;
    private Repository<Planet> planets;
    private int exploredPlanetsCount;


    public ControllerImpl() {
        this.astronauts = new AstronautRepository();
        this.planets = new PlanetRepository();
        this.exploredPlanetsCount = 0;
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut;
        if (type.equals("Biologist")) {
            astronaut = new Biologist(astronautName);
        } else if (type.equals("Geodesist")) {
            astronaut = new Geodesist(astronautName);
        } else if (type.equals("Meteorologist")) {
            astronaut = new Meteorologist(astronautName);
        } else {
            throw new IllegalArgumentException(ASTRONAUT_INVALID_TYPE);
        }

        astronauts.add(astronaut);
        return String.format(ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);
        if(items.length != 0) {
            planet.getItems().addAll(Arrays.asList(items));
        }
        planets.add(planet);

        return String.format(PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronaut;
        try {
            astronaut = astronauts.findByName(astronautName);
        } catch (Exception ex) {
            throw new IllegalArgumentException(String.format(ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }

        astronauts.remove(astronaut);
        return String.format(ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        List<Astronaut> suitable = astronauts.getModels().stream()
                .filter(a -> a.getOxygen() > 60)
                .collect(Collectors.toList());

        if(suitable.isEmpty()) {
            throw new IllegalArgumentException(PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }

        int astronautsCountBeforeMission = suitable.size();
        Planet planet = planets.findByName(planetName);
        Mission mission = new MissionImpl();
        mission.explore(planet, suitable);
        exploredPlanetsCount++;

        int deadAstronauts = astronautsCountBeforeMission - suitable.size();

        return String.format(PLANET_EXPLORED, planetName, deadAstronauts);
    }

    @Override
    public String report() {
        String astronautsInfo = astronauts.getModels().stream()
                .map(this::getAstronautInfo)
                .collect(Collectors.joining(System.lineSeparator()));

        String exploredPlanets = String.format(REPORT_PLANET_EXPLORED, exploredPlanetsCount);

        return String.format("%s%n" +
                "%s%n%s", exploredPlanets, REPORT_ASTRONAUT_INFO, astronautsInfo);
    }

    private String getAstronautInfo (Astronaut astronaut) {
        String bagOutput = astronaut.getBag().getItems().isEmpty()
                ? "none"
                : String.join(REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER, astronaut.getBag().getItems());

        String name = String.format(REPORT_ASTRONAUT_NAME, astronaut.getName());
        String oxygen = String.format(REPORT_ASTRONAUT_OXYGEN, astronaut.getOxygen());
        String bag = String.format(REPORT_ASTRONAUT_BAG_ITEMS, bagOutput);

        return String.format("%s%n" +
                "%s%n" +
                "%s",name , oxygen, bag);
    }
}
