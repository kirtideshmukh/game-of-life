import java.util.Arrays;

public class App {
  public static void main(String[] args) {
    GameOfLife game = new GameOfLife();
    Integer[][] previousState = {{1, 0, 0, 0}, {0, 0, 1, 0}, {0, 1, 1, 1}, {0, 0, 0, 0}};
    printCurrentState(previousState);
    Integer[][] nextState = game.nextStep(previousState);
    System.out.println("");
    printCurrentState(nextState);
  }

  private static void printCurrentState(Integer[][] state) {
    System.out.println(Arrays.toString(state[0]));
    System.out.println(Arrays.toString(state[1]));
    System.out.println(Arrays.toString(state[2]));
    System.out.println(Arrays.toString(state[3]));
  }
}
