package com.smartwaste.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smartwaste.backend.entity.Route;
import com.smartwaste.backend.repository.RouteRepository;

@Service
	public class RouteService {

	    private final RouteRepository routeRepository;

	    public RouteService(RouteRepository routeRepository) {
	        this.routeRepository = routeRepository;
	    }

	    public Route createRoute(Route route) {
	        return routeRepository.save(route);
	    }

	    public List<Route> getAllRoutes() {
	        return routeRepository.findAll();
	    }

	    public Route updateRoute(Long id, Route updated) {
	        Route route = routeRepository.findById(id).orElseThrow();
	        route.setRouteName(updated.getRouteName());
	        return routeRepository.save(route);
	    }

	    public void deleteRoute(Long id) {
	        routeRepository.deleteById(id);
	    }
	}

