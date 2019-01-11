package com.company;

public class Main {

    public static void main(String[] args) {
        Premiu oscar1990 = new Premiu("oscar", 1990);
        Premiu oscar2000 = new Premiu("oscar", 2000);
        Premiu oscar2010 = new Premiu("oscar", 2010);
        Premiu oscar2018 = new Premiu("oscar", 2018);

        Actor actorOscar1990 = new Actor("actor cu 2 oscaruri", 35, oscar1990, oscar2000);
        Actor actorOscar2010 = new Actor("actor cu oscar din 2000", 55, oscar2010);
        Actor actorOscar2018 = new Actor("actor cu oscar din 2018", 23, oscar2018);
        Actor actorFaraPremii01 = new Actor("actor fara oscar 01", 33);
        Actor actorFaraPremii02 = new Actor("actor fara oscar 02", 60);
        Actor actorFaraPremii03 = new Actor("actor fara oscar 02", 20);

        Film film1 = new Film(1990, "film cu actori de oscar", actorOscar1990, actorFaraPremii01);
        Film film2 = new Film(2010, "film cu actori fara premii2", actorFaraPremii01, actorFaraPremii02, actorFaraPremii03);
        Film film3 = new Film(2010, "film cu actori fara premii3", actorFaraPremii01, actorFaraPremii02, actorFaraPremii03);
        Film film4 = new Film(2018, "film cu actori de oscar", actorOscar2010, actorOscar2018, actorFaraPremii02);
        Film film5 = new Film(2018, "film cu actori fara premii5", actorFaraPremii02, actorFaraPremii03);

        Studio studio1 = new Studio("MGM", film1, film2);
        Studio studio2 = new Studio("Disney", film3, film4, film5);

        Studio[] studioDatabase = new Studio[]{studio1, studio2};


        System.out.println("Studio names that have published more than 2 movie: ");
        for (Studio studio : studioDatabase) {
            if (studio.filme.length > 2) System.out.println(" * " + studio.nume);
        }

        System.out.println("Studio names in which plays the actor 'actor cu 2 oscaruri'");
        for (Studio studio : studioDatabase) {
            boolean check = false;
            for (Film film : studio.filme) {
                for (Actor actor : film.actori)
                    if (actor.nume.equals("actor cu 2 oscaruri")) {
                        System.out.println(" * " + studio.nume);
                        check = true;
                        break;
                    }
                if(check == true) break;
            }
        }

        System.out.println("Movie names in which plays at least an actor with age above 50.");
        for (Studio studio : studioDatabase) {
            for (Film film : studio.filme) {
                for (Actor actor : film.actori)
                    if (actor.varsta > 50) {
                        System.out.println(" - " + film.nume);
                        break;
                    }
            }
        }

    }
}
