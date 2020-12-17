package cs.checkers.common;

/**
 * BoardTypes
 */
public enum BoardTypes {
  TwoPlayerChineseCheckers,
  ThreePlayerChineseCheckers,
  FourPlayerChineseCheckers,
  SixPlayerChineseCheckers;

  public Integer getNumOfPlayers(BoardTypes type) {
    switch (this) {
      case TwoPlayerChineseCheckers:
        return 2;
      case FourPlayerChineseCheckers:
        return 4;
      case SixPlayerChineseCheckers:
        return 6;
      case ThreePlayerChineseCheckers:
        return 3;
      default:
        return 0;
    }
  }
}
