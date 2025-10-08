package Main_Part.Utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MapManager {

    private static final String MAP_FOLDER = "resources/Maps/";
    private static final String DEFAULT_MAP_NAME = "map.map"; // 默认地图文件名
    private int[][] currentMap;

    public MapManager() {
        // load default map
        currentMap = readMapFromFile(MAP_FOLDER + DEFAULT_MAP_NAME);
        if (currentMap == null) {
            System.out.println("cannot load default map");
            currentMap = generateEmptyMap(10, 10);
        }
    }

    /**
     * read map from resources by index
     */
    public void readMap(int index) {
        String filePath = MAP_FOLDER + "map" + index + ".map";
        int[][] map = readMapFromFile(filePath);

        if (map != null) {
            currentMap = map;
            System.out.println("map successfully loaded" + filePath);
        } else {
            System.out.println("cannot load map at " + filePath + ", back to default map");
            currentMap = readMapFromFile(MAP_FOLDER + DEFAULT_MAP_NAME);
            if (currentMap == null) {
                currentMap = generateEmptyMap(10, 10);
            }
        }
    }

    /**
     * get current map
     */
    public int[][] getMap() {
        return currentMap != null ? currentMap : generateEmptyMap(10, 10);
    }

    /**
     * generate empty map at fixed size
     */
    public int[][] getMap(int width, int height) {
        return generateEmptyMap(width, height);
    }

    /**
     * read map data
     * file structure example:
     * 1 1 0 0 0
     * 0 1 0 2 2
     * 0 0 0 1 0
     */
    private int[][] readMapFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            return br.lines()
                    .map(line -> line.trim().split("\\s+"))
                    .map(arr -> {
                        int[] row = new int[arr.length];
                        for (int i = 0; i < arr.length; i++) {
                            row[i] = Integer.parseInt(arr[i]);
                        }
                        return row;
                    })
                    .toArray(int[][]::new);
        } catch (IOException e) {
            System.out.println("failed to load map " + filePath);
            return null;
        }
    }

    /**
     * generate empty map
     */
    private int[][] generateEmptyMap(int width, int height) {
        return new int[width][height];
    }
}
