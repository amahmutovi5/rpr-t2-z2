package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
private double pocetnatacka,krajnjatacka;
boolean pripada1,pripada2;

public Interval(double poc,double kraj,boolean pripada,boolean pripadaa) {
    if(kraj<poc) throw new IllegalArgumentException();
    pocetnatacka=poc;
    krajnjatacka=kraj;
    pripada1=pripada;
    pripada2=pripadaa;
}

    public Interval() {
    Interval i= null;
    }

    public boolean isNull() {
    if(pocetnatacka==0 && krajnjatacka==0 && !pripada1 && !pripada2) return true;
    return false;
    }
    public boolean isIn(double tacka) {
        if (pripada1 && tacka >= pocetnatacka && !pripada2 && tacka < krajnjatacka) return true;
        else if (pripada1 && tacka >= pocetnatacka && pripada2 && tacka <= krajnjatacka) return true;
        else if (!pripada1 && tacka > pocetnatacka && pripada2 && tacka <= krajnjatacka) return true;
        else return !pripada1 && tacka > pocetnatacka && !pripada2 && tacka < krajnjatacka;
    }

    public Interval intersect(Interval i) {
    Interval rez=new Interval(0,0,false,false);
    if(pocetnatacka>i.pocetnatacka) {
        rez.pocetnatacka=pocetnatacka;
        rez.pripada1=pripada1;
    } else {
        rez.pocetnatacka=i.pocetnatacka;
        rez.pripada1=i.pripada1;
    }
    if(krajnjatacka<=i.krajnjatacka) {
        rez.pripada2=pripada2;
        rez.krajnjatacka=krajnjatacka;
    } else{
        rez.krajnjatacka=i.krajnjatacka;
        rez.pripada2=i.pripada2;
    }
    return rez;
    }

public static Interval intersect(Interval i1, Interval i2) {
    Interval rez=new Interval();
    if(i1.pocetnatacka>=i2.pocetnatacka) {
        rez.pocetnatacka=i1.pocetnatacka;
        rez.pripada1=i1.pripada1;
    } else {
        rez.pocetnatacka=i2.pocetnatacka;
        rez.pripada1=i2.pripada1;
    }
    if(i1.krajnjatacka<=i2.krajnjatacka) {
        rez.pripada2=i1.pripada2;
        rez.krajnjatacka=i1.krajnjatacka;
    } else {
        rez.krajnjatacka=i2.krajnjatacka;
        rez.pripada2=i2.pripada2;
    }
    return rez;
}

    @Override
    public String toString() {
        if(pripada1 && pripada2) return "["+pocetnatacka+","+krajnjatacka+"]";
        else if(pripada1) return "["+pocetnatacka+","+krajnjatacka+")";
        else if(pripada2) return "("+pocetnatacka+","+krajnjatacka+"]";
        else if(this.isNull()) return "()";
        else return "("+pocetnatacka+","+krajnjatacka+")";
    }

    @Override
    public boolean equals(Object o) {
    Interval i=(Interval) o;
    return (pocetnatacka==i.pocetnatacka && krajnjatacka==i.krajnjatacka && pripada1==i.pripada1 && pripada2==i.pripada2);

    }
}

