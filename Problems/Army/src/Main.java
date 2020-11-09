class Army {

    public static void createArmy() {
        // Implement this method
        Unit testOne = new Unit("test1");
        Unit testwo = new Unit("test1");
        Unit testThree = new Unit("test1");
        Unit testfour = new Unit("test1");
        Unit testfice = new Unit("test1");
        Knight one = new Knight("first");
        Knight two = new Knight("second");
        Knight three = new Knight("third");
        General general = new General("Patton");
        Doctor doctor = new Doctor("House");
    }


    // Don't change the code below
    static class Unit {
        static String nameUnit;
        static int countUnit;

        public Unit(String name) {
            countUnit++;
            nameUnit = name;

        }
    }

    static class Knight {
        static String nameKnight;
        static int countKnight;

        public Knight(String name) {
            countKnight++;
            nameKnight = name;

        }
    }

    static class General {
        static String nameGeneral;
        static int countGeneral;

        public General(String name) {
            countGeneral++;
            nameGeneral = name;

        }
    }

    static class Doctor {
        static String nameDoctor;
        static int countDoctor;

        public Doctor(String name) {
            countDoctor++;
            nameDoctor = name;

        }
    }

    public static void main(String[] args) {
        createArmy();
        System.out.println(Unit.countUnit);
        System.out.println(Knight.countKnight);
        System.out.println(General.countGeneral);
        System.out.println(Doctor.countDoctor);
    }

}