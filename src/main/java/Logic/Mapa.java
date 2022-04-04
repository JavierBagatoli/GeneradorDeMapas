package Logic;

import static java.lang.Math.abs;

public class Mapa {
    private int sizeX = 124;
    private int sizeY = 70;
    private int map[][] = new int[500][500];
    private int mapBiome[][] = new int[500][500];
    private int mapRadiation[][] = new int[500][500];
    private int quantityMounts = 0;
    private int heightMounts = 0;
    private boolean isContinent = false;
    private final int rotPlanet = ((int)(Math.random()*40)-20);
    private final int sentidoRadicion = ((int)(Math.random()*4));
    private final double anchoRadiacionDiagonal = (Math.random()/3);
    private String nombreMapa;

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

    public int[][] getMapRadiation() {
        return mapRadiation;
    }

    public void setMapRadiation(int[][] mapRadiation) {
        this.mapRadiation = mapRadiation;
    }

    public String getNombreMapa() {
        return nombreMapa;
    }

    public void setNombreMapa(String nombreMapa) {
        this.nombreMapa = nombreMapa;
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
                
                if(isZonaLocalDentroMargenes(bioX, bioY)){
                    for(int x = bioX-2; x < bioX+2; x++){
                        for(int y = bioY-2; y < bioY+2; y++){
                            if(map[x][y] > 1){
                                isOk = true;
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
                                int proliferacionInusual = (int) (Math.random()*5);
                                if (proliferacionInusual == 2){
                                    mapBiome[x][y]++;
                                }
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
    
    private boolean isZonaLocalDentroMargenes(int x, int y){
        return x-2 > 2 && x+2 < sizeX && y-2 >2 && y+2 < sizeY-2;
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
            int midOfPlanet= (int)((sizeY/2));
            switch (sentidoRadicion) {
                case 1 -> { //Horizontal
                    for (int x = 0; x < sizeX; x++){
                        for (int y = 0; y < sizeY; y++){
                            int ruido = (int) ((Math.random() * 10) - 5);
                            int angulo = abs((int)  y - midOfPlanet-rotPlanet+ruido);
                            setValorRadiacion(x,y,angulo,midOfPlanet);
                        }
                    }
                }
                case 2 -> { //Diagonal izquierda superior a derecha inferior
                    for (int x = 0; x < sizeX; x++){
                        for (int y = 0; y < sizeY; y++){
                            int ruido = (int) ((Math.random() * 10) - 5);
                            int angulo = abs((int) (x - midOfPlanet - (y*anchoRadiacionDiagonal) -rotPlanet)+ruido); 
                            setValorRadiacion(x,y,angulo,midOfPlanet);
                        }}
                }
                case 3 -> { //Diagonal izquierda inferior a derecha superior
                    for (int x = 0; x < sizeX; x++){
                        for (int y = 0; y < sizeY; y++){
                            int ruido = (int) ((Math.random() * 10) - 5);
                            int angulo = abs((int) (x - midOfPlanet + (y*anchoRadiacionDiagonal) -rotPlanet)+ruido); 
                            setValorRadiacion(x,y,angulo,midOfPlanet);
                        }}
                }
                default -> {//vertical
                        midOfPlanet = (int)(sizeX/2);
                        for (int y = 0; y < sizeY; y++){
                                for (int x = 0; x < sizeX; x++){
                                        int ruido = (int) ((Math.random() * 10) - 5);
                                        int angulo = abs((int)  x - midOfPlanet-rotPlanet + ruido);
                                        setValorRadiacion(x,y,angulo,midOfPlanet);
                                        }}
                }
            }
            }
            
        return mapRadiation;
    }
    
    public void setValorRadiacion(int x, int y, int angulo, int midOfPlanet){ //Pinta o declara la radiacion que llega en un cradro
        if (angulo >= 0 && angulo <= (midOfPlanet*1)/9){
            mapRadiation[x][y] = 8;
        }else if((angulo > (midOfPlanet*1)/9) && (angulo <= (midOfPlanet*3)/9)){
            mapRadiation[x][y] = 7;
        }else if((angulo > (midOfPlanet*3)/9) && (angulo <= (midOfPlanet*6)/9)){
            mapRadiation[x][y] = 6;
        }else if((angulo > (midOfPlanet*6)/9) && (angulo <= (midOfPlanet*9)/9)){
            mapRadiation[x][y] = 5;
        }else{
            mapRadiation[x][y] = 4;
        }
    }
    
    //Algoritmos de terraformacion
    public void ebrio(int[][] map, int posX, int posY) {
        if (isDentroMapa(posX, posY)) {
            Coordenadas parXY = new Coordenadas(posX, posY);
            boolean isConstruible = (int) (Math.random() * 2 + 1) == 1;
            if (map[posX][posY] > map[posX - 1][posY]) {
                map[posX-1][posY] = map[posX][posY] -1;
                if (isConstruible && posX >= 1) {
                    setNivel(posX-1, posY-1, parXY);
                    setNivel(posX-1, posY+1, parXY);
                    if(posX > 1){
                        map[posX - 2][posY] = map[posX][posY] - 1;
                        continuarEbrio(map, posX - 2, posY);
                    }
                }
            }
            if (map[posX][posY] > map[posX + 1][posY]) {
                map[posX + 1][posY] = map[posX][posY] - 1;
                if (isConstruible && posX <= sizeX-1) {
                    setNivel(posX+1, posY-1, parXY);
                    setNivel(posX+1, posY+1, parXY);
                    if(posX < sizeX-2){
                        map[posX + 2][posY] = map[posX][posY] - 1;
                        continuarEbrio(map, posX + 2, posY);
                    }
                }
            }
            if (map[posX][posY] > map[posX][posY - 1]) {
                map[posX][posY - 1] = map[posX][posY] - 1;
                if (isConstruible && posY >= 1) {
                    setNivel(posX+1, posY-1, parXY);
                    setNivel(posX-1, posY-1, parXY);
                    if(posY > 1){
                        map[posX][posY - 2] = map[posX][posY] - 1;
                        continuarEbrio(map, posX, posY - 2);
                    }
                }
            }
            if (map[posX][posY] > map[posX][posY + 1]) {
                map[posX][posY + 1] = map[posX][posY] - 1;
                if (isConstruible && posY <= sizeY-1) {
                    setNivel(posX+1, posY+1, parXY);
                    setNivel(posX-1, posY+1, parXY);
                    if(posY < sizeY-2){
                        map[posX][posY + 2] = map[posX][posY] - 1;
                        continuarEbrio(map, posX, posY + 2);}
                }
            }
        }
    }

    private boolean isDentroMapa(int x, int y){
        return x > 0 && y > 0 && x < sizeX-1 && y < sizeY-1;
    }
    private void setNivel(int xObjetivo, int yObjetivo, Coordenadas origen){
        map[xObjetivo][yObjetivo] = map[origen.getX()][origen.getY()]-1;
    }
    public void continuarEbrio(int[][] map, int posX, int posY){
        if (isContinent){
            int continuar = (int)(Math.random()*3);
            if (continuar == 2){
                map[posX][posY]++;
                ebrio(map, posX, posY);
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
                            if (isDentroMapa(mx, my + iAlto)) {
                                map[mx][my + iAlto] = map[mx][my];
                            }
                        }
                        for (int iBajo = 0; iBajo < fBajo; iBajo++) {
                            if (isDentroMapa(mx, my - iBajo)) {
                                map[mx][my - iBajo] = map[mx][my];
                            }
                        }
                    }
                    case 1 -> {
                        //Horizontal
                        for (int iAlto = 0; iAlto < fAlto; iAlto++) {
                            if (isDentroMapa(mx + iAlto,my)) {
                                map[mx + iAlto][my] = map[mx][my];
                            }
                        }
                        for (int iBajo = 0; iBajo < fBajo; iBajo++) {
                            if (isDentroMapa(mx - iBajo, my )) {
                                map[mx - iBajo][my] = map[mx][my];
                            }
                        }
                    }
                    case 2 -> {
                        for (int iAlto = 0; iAlto < fAlto; iAlto++) {
                            if (isDentroMapa(mx + iAlto, my + iAlto)){
                                map[mx + iAlto][my + iAlto] = map[mx][my];
                            }
                        }
                        for (int iBajo = 0; iBajo < fBajo; iBajo++) {
                            if (isDentroMapa(mx - iBajo, my - iBajo)) {
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
                            if (isDentroMapa(mx - iBajo, my - iBajo)) {
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
    
    public String genNombreMapa(){
        String nombre = "";
        int longitudNombre = (int) (Math.random()*6)+3;
        for(int i = 0; i < longitudNombre; i++){
            char letra = (char) ((int) (Math.random()*26)+65);
            if (i > 0){
                char lastChar = nombre.charAt(nombre.length()-1);
                if(letra == 90){
                    nombre = nombre + "' ";
                }else if (isConsonante(lastChar)){
                    int vocal = (int) (Math.random()*5)+1;
                    letra = switch (vocal) {
                        case 1 -> 65;
                        case 2 -> 69;
                        case 3 -> 73;
                        case 4 -> 79;
                        case 5 -> 85;
                        default -> 89;
                    
                    };
                    nombre = nombre +letra;
                }else{
                    nombre = nombre + letra;
                }
            }else{
                nombre = nombre + letra;
            }
        }
        nombre = nombre.toLowerCase();
        nombre = nombre.replace(nombre.charAt(0), nombre.toUpperCase().charAt(0));
        return nombre;
    }
    private boolean isConsonante(char character){
        return character != 65 && character != 69  && character != 73 && character != 79 && character != 85;
    }
    public Mapa() {
    }

    public Mapa(int sizeX, int sizeY) {
        this.nombreMapa = genNombreMapa();
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }
}
