package Logic;

import static java.lang.Math.abs;
import static java.lang.Math.cos;

public class Mapa {
    private int sizeX = 124;
    private int sizeY = 70;
    private int map[][] = new int[500][500];
    private int mapBiome[][] = new int[500][500];
    private int mapRadiation[][] = new int[500][500];
    private int quantityMounts = 0;
    private int heightMounts = 0;
    private boolean isContinent = false;
    private int rotPlanet = ((int)(Math.random()*40)-20);

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
    //Algoritmo de Biomas
    public int[][] generarBiomas(){
        boolean isEmpty = true;
        for(int xx = 10; xx <= sizeX-30; xx++){
            for(int yy = 10; yy <= sizeY-30; yy++){
                if (mapBiome[xx][yy] > 0){
                    isEmpty = false;
                    break;
                }
            if (!isEmpty){
                break;
            }
            }}
        if (isEmpty){
            for(int i = 0; i < 15; i++){
                int bioX = (int)(Math.random()*sizeX);
                int bioY = (int)(Math.random()*sizeY);
                boolean isOk = false;
                
                if(bioX-2 > 2 && bioX+2 < sizeX && bioY-2 >2 && bioY+2 < sizeY-2){
                    for(int x = bioX-2; x < bioX+2; x++){
                        for(int y = bioY-2; y < bioY+2; y++){
                            if(map[x][y] > 1){
                                isOk = true;
                            }
                            if(isOk){
                                mapBiome[bioX][bioY] = 3;
                                break;
                            }
                        }
                    }
                }
                if(!isOk){i--;}
            }
                for(int c = 0; c < 3; c++){
                for(int x = 0; x < sizeX; x++){
                    for(int y = 0; y < sizeY; y++){
                        switch (mapBiome[x][y]) {
                            case 3 -> {
                                if (x > 0 && mapBiome[x-1][y]<1){
                                    mapBiome[x-1][y] = mapBiome[x][y]-1;}
                                if (x < sizeX && mapBiome[x+1][y]<1){
                                    mapBiome[x+1][y] = mapBiome[x][y]-1;}
                                if (y > 0 && mapBiome[x][y-1]<1){
                                    mapBiome[x][y-1] = mapBiome[x][y]-1;}
                                if (y < sizeY && mapBiome[x][y+1]<1){
                                    mapBiome[x][y+1] = mapBiome[x][y]-1;}
                                }
                            case 2 -> {
                                if (x > 0 && mapBiome[x-1][y]<1){
                                    mapBiome[x-1][y] = mapBiome[x][y]-1;}
                                if (x < sizeX && mapBiome[x+1][y]<1){
                                    mapBiome[x+1][y] = mapBiome[x][y]-1;}
                                if (y > 0 && mapBiome[x][y-1]<1){
                                    mapBiome[x][y-1] = mapBiome[x][y]-1;}
                                if (y < sizeY && mapBiome[x][y+1]<1){
                                    mapBiome[x][y+1] = mapBiome[x][y]-1;}
                                }
                        }

                    }
                }
            }
        }
        return mapBiome;
    }
    //Radiacion planetaria
    public int[][] radiation(){
        boolean isEmpty = true;
        for(int xx = sizeX-60; xx <= sizeX-30; xx++){
            for(int yy = sizeX-60; yy <= sizeX-30; yy++){
                if (mapRadiation[xx][yy] > 0){
                    isEmpty = false;
                    break;
                }
            if (!isEmpty){
                break;
            }
            }}
        if (isEmpty){
            for (int x = 0; x < sizeX; x++){
                for (int y = 0; y < sizeY; y++){
                    int midOfPlanet = (int )(sizeY/2);
                    int angulo = abs((int)  y - midOfPlanet-rotPlanet);
                    if (angulo > 0 && angulo < (midOfPlanet*1)/9){
                        mapRadiation[x][y] = 8;
                    }else if((angulo > (midOfPlanet*1)/9) && (angulo <= (midOfPlanet*2)/9)){
                        mapRadiation[x][y] = 7;
                    }else if((angulo > (midOfPlanet*2)/9) && (angulo <= (midOfPlanet*3)/9)){
                        mapRadiation[x][y] = 6;
                    }else if((angulo > (midOfPlanet*3)/9) && (angulo <= (midOfPlanet*4)/9)){
                        mapRadiation[x][y] = 5;
                    }else if((angulo > (midOfPlanet*4)/9) && (angulo <= (midOfPlanet*5)/9)){
                        mapRadiation[x][y] = 4;
                    }else if((angulo > (midOfPlanet*5)/9) && (angulo <= (midOfPlanet*6)/9)){
                        mapRadiation[x][y] = 3;
                    }else if((angulo > (midOfPlanet*6)/9) && (angulo <= (midOfPlanet*7)/9)){
                        mapRadiation[x][y] = 2;
                    }else if((angulo > (midOfPlanet*7)/9) && (angulo <= (midOfPlanet*8)/9)){
                        mapRadiation[x][y] = 1;
                    }else{
                        mapRadiation[x][y] = 0;
                    }
                }
            }
        }
        return mapRadiation;
    }
    //Algoritmos de terraformacion
    public void continuarEbrio(int[][] map, int posX, int posY){
        if (isContinent){
            int continuar = (int)(Math.random()*3);
            if (continuar == 2){
                map[posX][posY]++;
                ebrio(map, posX, posY);
            }
        }
    }
    
    public void ebrio(int[][] map, int posX, int posY) {
        if (posX > 0 && posY > 0 && posX < sizeX-1 && posY < sizeY-1) {
            if (map[posX][posY] > map[posX - 1][posY]) {
                map[posX - 1][posY] = map[posX][posY] - 1;
                if ((int) (Math.random() * 2 + 1) == 1 && posX > 0 || posX == 1) {
                    map[posX - 1][posY - 1] = map[posX][posY] - 1;
                    map[posX - 1][posY + 1] = map[posX][posY] - 1;
                    map[posX - 1][posY] = map[posX][posY] - 1;
                    if(posX > 1){
                        map[posX - 2][posY] = map[posX][posY] - 1;
                        continuarEbrio(map, posX - 2, posY);
                    }
                }
            }
            if (map[posX][posY] > map[posX + 1][posY]) {
                map[posX + 1][posY] = map[posX][posY] - 1;
                if ((int) (Math.random() * 2 + 1) == 1 && posX < sizeX-1 || posX == sizeX-1) {
                    map[posX + 1][posY - 1] = map[posX][posY] - 1;
                    map[posX + 1][posY + 1] = map[posX][posY] - 1;
                    map[posX + 1][posY] = map[posX][posY] - 1;
                    if(posX < sizeX-2){
                        map[posX + 2][posY] = map[posX][posY] - 1;
                        continuarEbrio(map, posX + 2, posY);
                    }
                }
            }
            if (map[posX][posY] > map[posX][posY - 1]) {
                map[posX][posY - 1] = map[posX][posY] - 1;
                if ((int) (Math.random() * 2 + 1) == 1 && posY > 0 || posY == 1) {
                    map[posX + 1][posY - 1] = map[posX][posY] - 1;
                    map[posX - 1][posY - 1] = map[posX][posY] - 1;
                    map[posX][posY - 1] = map[posX][posY] - 1;
                    if(posY > 1){
                        map[posX][posY - 2] = map[posX][posY] - 1;
                        continuarEbrio(map, posX, posY - 2);
                    }
                }
            }
            if (map[posX][posY] > map[posX][posY + 1]) {
                map[posX][posY + 1] = map[posX][posY] - 1;
                if ((int) (Math.random() * 2 + 1) == 1 && posY < sizeY-1 || posY == sizeY-1) {
                    map[posX + 1][posY + 1] = map[posX][posY] - 1;
                    map[posX - 1][posY + 1] = map[posX][posY] - 1;
                    map[posX][posY + 1] = map[posX][posY] - 1;
                    if(posY < sizeY-2){
                        map[posX][posY + 2] = map[posX][posY] - 1;
                        continuarEbrio(map, posX, posY + 2);}
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
                    if (c <= 5) {
                        ebrio(map, x, y);
                    } else {
                        ebrio(map, x, sizeY-y);
                    }
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
