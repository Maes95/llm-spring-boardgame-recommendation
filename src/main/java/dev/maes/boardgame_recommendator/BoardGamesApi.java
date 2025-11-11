package dev.maes.boardgame_recommendator;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/boardgames")
public class BoardGamesApi {
    
    @Autowired
    private ChatModel chatModel;

    @Autowired
    private BoardGameRepository boardGameRepository;

    @PostMapping("/recommend")
    public Map<String, String> recommendBoardGame(@RequestBody String userInput) {

        // Obtener todos los juegos de la base de datos
        List<BoardGame> allGames = boardGameRepository.findAll();

        // Construir la información de los juegos para el prompt
        StringBuilder gamesInfo = new StringBuilder();
        for (BoardGame game : allGames) {
            gamesInfo.append("- ").append(game.toString()).append("\n");
        }

        // Construir el prompt en castellano
        String prompt = String.format(
            """
            Eres un experto en recomendación de juegos de mesa. Un usuario te ha compartido sus preferencias o situación:
            
            "%s"
            
            Aquí está la lista de juegos de mesa disponibles:
            
            %s
            
            Basándote en las preferencias del usuario y las características de los juegos disponibles, 
            recomienda el juego de mesa más adecuado. Explica brevemente por qué es la mejor opción para este usuario.
            Sé amigable y entusiasta en tu recomendación.
            
            IMPORTANTE: Tu respuesta debe ser en texto plano, sin usar formato markdown (nada de **, *, #, etc.), 
            sin saltos de línea y limitada a un máximo de 2-3 líneas. Toda la respuesta debe estar en un único párrafo continuo.
            """,
            userInput,
            gamesInfo.toString()
        );

        // Llamar al modelo de chat
        String recommendation = chatModel.call(prompt);

        // Devolver la respuesta
        return Map.of(
            "user_input", userInput,
            "recommendation", recommendation
        );
    }

}
