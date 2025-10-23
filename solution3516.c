int findClosest(int x, int y, int z) {
    int per1 = abs(x-z) ;
    int per2 = abs(y-z) ;
    if (per1 < per2){
        return 1;
    }
        
    else if (per1 > per2){
        return 2;
    }
    else{
        return 0;
    }
}
