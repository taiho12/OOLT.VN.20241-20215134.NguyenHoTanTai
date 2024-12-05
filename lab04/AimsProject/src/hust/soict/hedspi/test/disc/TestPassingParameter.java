//package hust.soict.hedspi.test.disc;
//
//import hust.soict.hedspi.aims.media.DVD;
//
//public class TestPassingParameter {
//    public static void main(String[] args) {
//        DVD jungleDVD = new DVD("Jungle");
//        DVD cinderellaDVD = new DVD("Cinderella");
//
//        swap(jungleDVD, cinderellaDVD);
//        System.out.println("Jungle disc title: " + jungleDVD.getTitle());
//        System.out.println("Cinderella disc title: " + cinderellaDVD.getTitle());
//
//        changeTitle(jungleDVD, cinderellaDVD.getTitle());
//        System.out.println("Jungle disc title: " + jungleDVD.getTitle());
//    }
//
//    public static void swap(Object o1, Object o2) {
//        Object tmp = o1;
//        o1 = o2;
//        o2 = tmp;
//    }
//
//    public static void swap(DVDWrapper w1, DVDWrapper w2) {
//        DVD tmp = w1.disc;
//        w1.disc = w2.disc;
//        w2.disc = tmp;
//    }
//
//    public static void changeTitle(DVD disc, String title) {
//        String oldTitle = disc.getTitle();
//        disc.setTitle(title);
//        disc = new DVD(oldTitle);
//    }
//}
//
//class DVDWrapper {
//    public DVD disc;
//
//    public DVDWrapper(DVD disc) {
//        this.disc = disc;
//    }
//}
