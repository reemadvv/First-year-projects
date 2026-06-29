class Engine { // كلاس المحرك
	String type; // نوع المركبه
    double capacity; // سعه المحرك
    int hp;// قوه المحرك بالحصان
    public Engine(String type, double capacity, int hp) { //الكونستركتر
        this.type = type;
        this.capacity = capacity;
        this.hp = hp;
    }
    public void showEngine() { // دالة عرض الخصائص اعلاه
        System.out.println("Engine: " + type + ", " + capacity + "L, " + hp + " HP");
    }
}
abstract class Vehicle { //Abstract parent class representing a general vehicle
	int id;
	String  brand, model;
    double pricePerDay;// االسعر لليوم الواحد
    boolean available = true;// توفر المركبه
    Engine engine;//Composition-> each vehicle has an Engine object describing its engine details
//Constructor فيه جميع خصائص الكلاس وخصائص المحرك
    public Vehicle(int id, String brand, String model, double price, Engine engine) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.pricePerDay = price;
        this.engine = engine;
    }
    public abstract double calculateTotal();//  Polymorphism Abstract method لازم كل كلاس ابن ينفذها
    public void printInfo() { //داله العرض 
    	String status; // if statement لحاله المركبه
    	if (available) {
    	    status = "Available";
    	} else {
    	    status = "Not Available";
    	}
    	// طباعه الخصائص
        System.out.println("ID: " + id + " , " + brand + " " + model + " , Price: $" + pricePerDay + " , Status: " + status);
        engine.showEngine();// طباعه خصائص المحرك
    }
}
class Car extends Vehicle { // يرث من كلاس Vehicle
 public Car(int id, String brand, String model, double price, Engine engine) { // كونستركتور يمرر بيانات الكلاس vehicle
        super(id, brand, model, price, engine); 
    }
    @Override // استعملناها عشان كل مركبه لها اليه حساب مختلفه ولان الداله موروثه 
    public double calculateTotal() {//Polymorphism
        return pricePerDay ; // سعر الايجار باليوم الواحد
    }
}
class Truck extends Vehicle { // vehicle مركبات دفع رباعيه ترث من 
 public Truck(int id, String brand, String model, double price, Engine engine) {//كونستركتر يمرر البيانات الموروثه من كلاس vehicle
        super(id, brand, model, price, engine);
    }

    @Override // استعملناها عشان كل مركبه لها اليه حساب مختلفه ولان الداله موروثه 
    public double calculateTotal() { //Polymorphism
        return pricePerDay * 1.2; // سعر اليوم * رسوم  المركبه
    }
}
class RentalSystem { 
	public static void bubbleSort(Vehicle[] arr) { // الجزء الي درسته بمقرر Data structur
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // المقارنة بناءً على سعر المركبة لليوم الواحد
                if (arr[j].pricePerDay > arr[j + 1].pricePerDay) {
                    // عملية التبديل (Swap) للمركبات كاملة بجميع خصائصها ومحركاتها
                    Vehicle temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        // إنشاء محركات
        Engine e1 = new Engine("Petrol", 2.5, 200);
        Engine e2 = new Engine("Diesel", 4.0, 300);

        // إنشاء المركبات
        Vehicle car1 = new Car(111, "Toyota", "Camry", 100, e1);
        Vehicle car2 = new Car(222, "Honda", "Civic", 90, e1);
        Vehicle truck1 = new Truck(333, "Volvo", "X", 150, e2);

        // جعل السيارة الثانية (Honda) محجوزة
        car2.available = false;

        // مصفوفة المركبات
        Vehicle[] vehicles = {car1, car2, truck1};
        //  ترتيب الكائنات حسب اسعارها من الاصغر الى الاكبرباستخدام ال bubble sort 
        bubbleSort(vehicles);
        // طباعة كل المركبات
        System.out.println("Available Vehicles:\n");
         for (int i = 0; i < vehicles.length; i++) {
            vehicles[i].printInfo();
            System.out.println("Total Rental Cost: SAR" + vehicles[i].calculateTotal());
            System.out.println("\t---");
        }
    }
}
