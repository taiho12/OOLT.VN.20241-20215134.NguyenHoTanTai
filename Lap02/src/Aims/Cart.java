package Aims;
//Nguyễn Hồ Tấn Tài 20215134

class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED]; // mang luu cac dia hien tai
    public int numberOfItems = 0; //So luong dia hien tai trong cart
    //Phuong thuc them 1 dia moi vao cart

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (this.numberOfItems == 0) {
            this.itemsOrdered[0] = disc;
            this.numberOfItems++;
            System.out.println("The disc " + disc.getTitle() + " has been added");

        } //Neu cart da day in ra thong bao
        else if (this.numberOfItems >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full!!!");

        } //Neu khong tien hanh them binh thuong va in ra thong bao cho nguoi dung
        else {
            this.itemsOrdered[this.numberOfItems] = disc;
            this.numberOfItems++;
            System.out.println("The disc " + disc.getTitle() + " has been added");
        }
    }
    //Xoa 1 dia ra khoi cart
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        //Neu cart dang rong
        if (this.numberOfItems == 0) {
            System.out.println("The cart is empty now so cannot remove any discs");
        } else {
            // Kiem tra disc co ton tai trong cart khong
            for (int i = 0; i < this.numberOfItems; ++i) {
                // Neu ton tai thi tien hanh xoa va in ra thong bao
                if (this.itemsOrdered[i].equals(disc)) {
                    for (int j = i; j < this.numberOfItems; ++j) {
                        this.itemsOrdered[j] = this.itemsOrdered[j + 1];
                    }
                    this.numberOfItems--;
                    System.out.println("The disc " + disc.getTitle() + " has been removed from the cart");
                    break;
                }
                if(i==this.numberOfItems-1) {
                    //Neu khong co dia can xoa thi in ra thong bao
                    System.out.println("The disc " + disc.getTitle() + " doesn't exist in the cart");
                }
            }

        }
    }
    //Tinh tong gia tri cart hien tai
    public float totalCost() {
        float cost = 0f;
        for (int i = 0; i < this.numberOfItems; ++i) {
            cost += this.itemsOrdered[i].getCost();
        }
        return cost;
    }
    //In ra toan bo thong tin ve cart gom cac dia trong cart va tong tien
    public void  printAllDisc() {
        System.out.println("\n***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < this.numberOfItems ; i++) {
            System.out.println((i + 1) + ". " + this.itemsOrdered[i].getTitle());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("**************************************************");

    }

}
