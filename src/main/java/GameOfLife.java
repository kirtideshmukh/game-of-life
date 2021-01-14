public class GameOfLife {

  public static final int ALIVE = 1;
  public static final int DEAD = 0;

  public Integer[][] nextStep(Integer[][] previousState) {
    int rowLength = previousState.length;
    int colLength = previousState[0].length;
    Integer[][] nextState = new Integer[rowLength][colLength];

    for (int row = 0; row < rowLength; row++) {
      for (int col = 0; col < colLength; col++) {
        if (!willBeToxic(previousState, row, col)) {
          nextState[row][col] = previousState[row][col];
        } else if (willDeadCellBeActive(previousState, row, col)) {
          nextState[row][col] = ALIVE;
        } else {
          nextState[row][col] = DEAD;
        }
      }
    }
    return nextState;
  }

  private boolean willDeadCellBeActive(Integer[][] previousState, int row, int col) {
    if (previousState[row][col] != DEAD) {
      return false;
    }
    Integer liveNeighboursCount = getLiveNeighboursCount(previousState, row, col);
    return liveNeighboursCount == 3;
  }

  private boolean willBeToxic(Integer[][] previousState, int row, int col) {
    Integer liveNeighboursCount = getLiveNeighboursCount(previousState, row, col);
    return isUnderpopulation(liveNeighboursCount) || isOverPopulation(liveNeighboursCount);
  }

  private Integer getLiveNeighboursCount(Integer[][] previousState, int row, int col) {
    Integer[][] neighbourDirections =
        new Integer[][] {{1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}};
    Integer liveNeighboursCount = 0;
    for (Integer[] neighbour : neighbourDirections) {
      try {
        liveNeighboursCount += previousState[row + neighbour[0]][col + neighbour[1]];
      } catch (ArrayIndexOutOfBoundsException e) {
        liveNeighboursCount += 0;
      }
    }
    return liveNeighboursCount;
  }

  private boolean isOverPopulation(Integer liveNeighboursCount) {
    return liveNeighboursCount > 3;
  }

  private boolean isUnderpopulation(Integer liveNeighboursCount) {
    return liveNeighboursCount < 2;
  }
}
