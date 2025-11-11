package dev.maes.boardgame_recommendator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class DatabaseInitializer {
    
    @Autowired
    private BoardGameRepository boardGameRepository;

    @PostConstruct
    public void init() {
        // Limpiar la base de datos
        boardGameRepository.deleteAll();
        
        // Juego 1
        BoardGame catan = new BoardGame(
            "Catan",
            "Un juego de estrategia donde los jugadores compiten por colonizar una isla recolectando recursos y construyendo asentamientos.",
            45.99,
            "Estrategia",
            "Kosmos"
        );
        
        // Juego 2
        BoardGame pandemic = new BoardGame(
            "Pandemic",
            "Juego cooperativo donde los jugadores trabajan juntos como equipo de especialistas para curar enfermedades mortales que amenazan al mundo.",
            39.99,
            "Cooperativo",
            "Z-Man Games"
        );
        
        // Juego 3
        BoardGame ticketToRide = new BoardGame(
            "Ticket to Ride",
            "Los jugadores recolectan cartas de trenes para reclamar rutas ferroviarias que conectan ciudades en un mapa.",
            49.99,
            "Familiar",
            "Days of Wonder"
        );
        
        // Juego 4
        BoardGame carcassonne = new BoardGame(
            "Carcassonne",
            "Un juego de construcción de territorio donde los jugadores colocan fichas para crear un paisaje medieval y obtener puntos.",
            34.99,
            "Estrategia",
            "Hans im Glück"
        );
        
        // Juego 5
        BoardGame codenames = new BoardGame(
            "Codenames",
            "Dos equipos compiten para identificar a sus agentes secretos mediante pistas de una palabra dadas por sus maestros de espías.",
            19.99,
            "Fiesta",
            "Czech Games Edition"
        );
        
        // Juego 6
        BoardGame azul = new BoardGame(
            "Azul",
            "Los jugadores compiten como artesanos decorando las paredes del Palacio Real de Évora con azulejos.",
            39.99,
            "Abstracto",
            "Plan B Games"
        );
        
        // Juego 7
        BoardGame wingspan = new BoardGame(
            "Wingspan",
            "Juego de construcción de motores sobre observación de aves donde los jugadores atraen aves a su reserva de vida silvestre.",
            64.99,
            "Estrategia",
            "Stonemaier Games"
        );
        
        // Juego 8
        BoardGame splendor = new BoardGame(
            "Splendor",
            "Los jugadores asumen el papel de comerciantes del Renacimiento adquiriendo minas, medios de transporte y tiendas.",
            39.99,
            "Estrategia",
            "Space Cowboys"
        );
        
        // Juego 9
        BoardGame dixit = new BoardGame(
            "Dixit",
            "Un juego de narración creativa donde los jugadores usan cartas ilustradas para crear historias y adivinar las de otros.",
            29.99,
            "Fiesta",
            "Libellud"
        );
        
        // Juego 10
        BoardGame terraformingMars = new BoardGame(
            "Terraforming Mars",
            "Las corporaciones compiten para terraformar Marte aumentando la temperatura, el nivel de oxígeno y la cobertura oceánica.",
            69.99,
            "Estrategia",
            "FryxGames"
        );
        
        // Guardar todos los juegos en la base de datos
        boardGameRepository.save(catan);
        boardGameRepository.save(pandemic);
        boardGameRepository.save(ticketToRide);
        boardGameRepository.save(carcassonne);
        boardGameRepository.save(codenames);
        boardGameRepository.save(azul);
        boardGameRepository.save(wingspan);
        boardGameRepository.save(splendor);
        boardGameRepository.save(dixit);
        boardGameRepository.save(terraformingMars);
        
        System.out.println("✅ Base de datos inicializada con " + boardGameRepository.count() + " juegos de mesa");
    }
}
