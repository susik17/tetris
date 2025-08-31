package tetris;

public class Tetrimino {
    private ShapeType shapeType;
    private int rotationState;        // 0-3 -> 0°, 90°, 180°, 270°
    private int[][][] shapes;         // rotation matrices
    public int x, y;                  // position on board top-left

    // Constructor - spawn at top center
    public Tetrimino(ShapeType type, int boardWidth) {
        this.shapeType = type;
        this.rotationState = 0;
        this.shapes = ShapeShapes.getShapes(type);
        this.x = (boardWidth - shapes[0][0].length) / 2;  // center horizontally
        this.y = 0;
    }

    public int[][] getCurrentShape() {
        return shapes[rotationState];
    }

    public void rotate() {
        rotationState = (rotationState + 1) % shapes.length;
    }

    public void rotateBack() {
        rotationState = (rotationState - 1 + shapes.length) % shapes.length;
    }

    // Optional: getter for shapeType
    public ShapeType getShapeType() {
        return shapeType;
    }
}
