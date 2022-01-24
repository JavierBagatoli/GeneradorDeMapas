package Logic;

public class Mapa {
    private int sizeX = 124;
    private int sizeY = 70;
    private int map[][] = new int[sizeX][sizeY];
    private int mapBiome[][] = new int[sizeX][sizeY];
    private int quantityMounts = 0;
    private int heightMounts = 0;
    private boolean isContinent = false;

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public int[][] getMap() {
        return map;
    }

    public void setMap(int[][] map) {
        this.map = map;
    }
    
    public int[][] getMapBiome() {
        return mapBiome;
    }

    public void setMapBiome(int[][] mapBiome) {
        this.mapBiome = mapBiome;
    }

    public int getQuantityMounts() {
        return quantityMounts;
    }

    public void setQuantityMounts(int quantityMounts) {
        this.quantityMounts = quantityMounts;
    }

    public int getHeightMounts() {
        return heightMounts;
    }

    public void setHeightMounts(int heightMounts) {
        this.heightMounts = heightMounts;
    }

    public boolean isIsContinent() {
        return isContinent;
    }

    public void setIsContinent(boolean isContinent) {
        this.isContinent = isContinent;
    }

    //Algoritmos de terraformacion
    public void continuarEbrio(int[][] map, int posX, int posY){
        if (isContinent){
            int continuar = (int)(Math.random()*3);
            if ( continuar == 2){
                map[posX][posY]++;
                ebrio(map, posX, posY);
            }
        }
    }
    
    public void ebrio(int[][] map, int posX, int posY) {
        if (posX > 0 && posY > 0 && posX < 122 && posY < 66) {
            if (map[posX][posY] > map[posX - 1][posY]) {
                map[posX - 1][posY] = map[posX][posY] - 1;
                if ((int) (Math.random() * 2 + 1) == 1 && posX > 2) {
                    map[posX - 1][posY - 1] = map[posX][posY] - 1;
                    map[posX - 1][posY + 1] = map[posX][posY] - 1;
                    map[posX - 2][posY] = map[posX][posY] - 1;
                    continuarEbrio(map, posX - 2, posY);
                }
            }
            if (map[posX][posY] > map[posX + 1][posY]) {
                map[posX + 1][posY] = map[posX][posY] - 1;
                if ((int) (Math.random() * 2 + 1) == 1 && posX < 60) {
                    map[posX + 1][posY - 1] = map[posX][posY] - 1;
                    map[posX + 1][posY + 1] = map[posX][posY] - 1;
                    map[posX + 2][posY] = map[posX][posY] - 1;
                    continuarEbrio(map, posX + 2, posY);
                }
            }
            if (map[posX][posY] > map[posX][posY - 1]) {
                map[posX][posY - 1] = map[posX][posY] - 1;
                if ((int) (Math.random() * 2 + 1) == 1 && posY > 2) {
                    map[posX + 1][posY - 1] = map[posX][posY] - 1;
                    map[posX - 1][posY - 1] = map[posX][posY] - 1;
                    map[posX][posY - 2] = map[posX][posY] - 1;
                    continuarEbrio(map, posX, posY - 2);
                }
            }
            if (map[posX][posY] > map[posX][posY + 1]) {
                map[posX][posY + 1] = map[posX][posY] - 1;
                if ((int) (Math.random() * 2 + 1) == 1 && posY < 33) {
                    map[posX + 1][posY + 1] = map[posX][posY] - 1;
                    map[posX - 1][posY + 1] = map[posX][posY] - 1;
                    map[posX][posY + 2] = map[posX][posY] - 1;
                    continuarEbrio(map, posX, posY + 2);
                }
            }
        }
    }

    //Generar Mapa
    public int[][] generateMounts() {
        for (int c = 0; c < quantityMounts; c++) {
            int mx = (int) (Math.random() * (sizeX - 4) + 2);
            int my = (int) (Math.random() * (sizeY - 4) + 2);
            int alturaMinima = 1;
            if (isContinent) {
                alturaMinima = 2;
            }

            map[mx][my] = (int) (Math.random() * heightMounts + alturaMinima);

            if (isContinent) {  //Generar cadenas montaniosas
                int fT = (int) (Math.random() * 4); //falla tectonica direccion
                int fAlto = (int) (Math.random() * 6 + 2); //Altura por encima del centro
                int fBajo = (int) (Math.random() * 6 + 2); //Altura por debajo del centro
                switch (fT) {
                    case 0 -> {
                        //vertical
                        for (int iAlto = 0; iAlto < fAlto; iAlto++) {
                            if (my + iAlto < sizeY) {
                                map[mx][my + iAlto] = map[mx][my];
                            }
                        }
                        for (int iBajo = 0; iBajo < fBajo; iBajo++) {
                            if (my - iBajo > 0) {
                                map[mx][my - iBajo] = map[mx][my];
                            }
                        }
                    }
                    case 1 -> {
                        //Horizontal
                        for (int iAlto = 0; iAlto < fAlto; iAlto++) {
                            if (mx + iAlto < sizeX) {
                                map[mx + iAlto][my] = map[mx][my];
                            }
                        }
                        for (int iBajo = 0; iBajo < fBajo; iBajo++) {
                            if (mx - iBajo > 0) {
                                map[mx - iBajo][my] = map[mx][my];
                            }
                        }
                    }
                    case 2 -> {
                        for (int iAlto = 0; iAlto < fAlto; iAlto++) {
                            if (mx + iAlto < sizeX && my + iAlto < sizeY) {
                                map[mx + iAlto][my + iAlto] = map[mx][my];
                            }
                        }
                        for (int iBajo = 0; iBajo < fBajo; iBajo++) {
                            if (mx - iBajo > 0 && my - iBajo > 0) {
                                map[mx - iBajo][my - iBajo] = map[mx][my];
                            }
                        }
                    }
                    default -> {
                        for (int iAlto = 0; iAlto < fAlto; iAlto++) {
                            if (mx + iAlto < sizeX && my + iAlto < sizeY) {
                                map[mx + iAlto][my + iAlto] = map[mx][my];
                            }
                        }
                        for (int iBajo = 0; iBajo < fBajo; iBajo++) {
                            if (mx - iBajo > 0 && my - iBajo > 0) {
                                map[mx - iBajo][my - iBajo] = map[mx][my];
                            }
                        }
                    }

                }
            }
        }
        for (int c = 0; c < 10; c++) {
            for (int x = 0; x < sizeX; x++) {
                for (int y = 0; y < sizeY; y++) {
                    ebrio(map, x, y);
                }
            }
        }
        return map;
    }
    
    public Mapa() {
    }

    public Mapa(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }
}
