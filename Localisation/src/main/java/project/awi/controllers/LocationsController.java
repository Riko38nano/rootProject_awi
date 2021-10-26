package project.awi.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import project.awi.models.Location;
import project.awi.repositories.LocationRepository;

import java.util.List;
import java.util.Properties;

@RestController
@RequestMapping("/api/v1/locations")
public class LocationsController {
    @Autowired
    private LocationRepository locationRepository;

    Properties props = new Properties();
    //props.put(StreamsConfig.APPLICATION_ID_CONFIG,"localisation-events");
    //props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");

    //KStream<String, String> textLines = builder.stream("quickstart-events");


    @GetMapping
    public List<Location> list() {
        return locationRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Location get(@PathVariable Long id) {
        if (!locationRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Location with id:" + id + "not found");
        }
        return locationRepository.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Location create(@RequestBody final Location location) {
        return locationRepository.saveAndFlush(location);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        locationRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Location update(@PathVariable Long id, @RequestBody Location location) {
        Location existingLocation = locationRepository.getById(id);
        BeanUtils.copyProperties(location, existingLocation, "location_id");
        return locationRepository.saveAndFlush(existingLocation);
    }
}
