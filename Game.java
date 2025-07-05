import static spark.Spark.*;

public class Game {
    public static void main(String[] args) {
        port(8080); // Railway default port

        get("/", (req, res) -> {
            return """
                <h1>Rock Paper Scissors</h1>
                <form action="/play">
                    <label>Choose your move:</label>
                    <select name="move">
                        <option value="rock">Rock</option>
                        <option value="paper">Paper</option>
                        <option value="scissors">Scissors</option>
                    </select>
                    <button type="submit">Play</button>
                </form>
            """;
        });

        get("/play", (req, res) -> {
            String userMove = req.queryParams("move");
            String[] moves = {"rock", "paper", "scissors"};
            String computerMove = moves[(int) (Math.random() * 3)];

            String result;
            if (userMove.equals(computerMove)) {
                result = "It's a tie!";
            } else if (
                (userMove.equals("rock") && computerMove.equals("scissors")) ||
                (userMove.equals("scissors") && computerMove.equals("paper")) ||
                (userMove.equals("paper") && computerMove.equals("rock"))
            ) {
                result = "You win!";
            } else {
                result = "You lose!";
            }

            return "<p>You chose: " + userMove + "</p>" +
                   "<p>Computer chose: " + computerMove + "</p>" +
                   "<h2>" + result + "</h2>" +
                   "<a href='/'>Play Again</a>";
        });
    }
}
