import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class tp1 {
    public static class Task {
        String tasks;
        boolean bool;
        public Task(String tasks){
            this.tasks = tasks;
            this.bool = false;

        }
    
        
    }

    public static void addtask(ArrayList<Task> tasks,Scanner scanner){    //الاضافة 
        System.err.println("ادخل المهمة الجديدة");
        String text = scanner.nextLine();
        if(text!=null && !text.trim().isEmpty()){
            tasks.add(new Task(text));
        }else{
            System.out.println("النص فارغ ");
        }
    }
    public static void saveToFile(ArrayList<Task> tasks) {
    try (FileWriter writer = new FileWriter("tasks.txt")) {
        for (int i = 0; i < tasks.size(); i++) {
            Task t = tasks.get(i);
            String status = t.bool ? "YES" : "NO";
            writer.write(status + " | " + t.tasks + "\n");
        }
        System.out.println(" تم حفظ قائمة المهام في الملف 'tasks.txt' بنجاح!");
    } catch (IOException e) {
        System.out.println(" حدث خطأ أثناء حفظ الملف!");
    }
    }

    public static void displaytask(ArrayList<Task> tasks){ //عرض المهام
        System.out.println("قائمة المهام الموجودة");
        if (tasks.isEmpty()) {
            System.out.println("لا توجد مهام بعد");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            Task t = tasks.get(i);
            String sttic = t.bool? "yes" : "NO";
            System.out.println((i+1) + "=>" + t.tasks + " =>"+sttic);
        }
    }

    public static void updatetask(ArrayList<Task> tasks,Scanner scanner){//تعديل مهمة
        displaytask(tasks);
        if (tasks.isEmpty()){
            return;
        }
        System.err.println("اختر مهمة لتعديلها");
        int a =scanner.nextInt();
        scanner.nextLine();
        int b =a-1;
        if (b >= 0 && b < tasks.size()){
            System.out.println("ادخل النص الجديد");
            String newtext = scanner.nextLine();
            Task t = tasks.get(b);
            t.tasks=newtext;
        }else{
            System.out.println("خطا في رقم المهمة");
        }
    }

    public static void changetask(ArrayList<Task> tasks,Scanner scanner){//تعديل حالة مهمة
        displaytask(tasks);
        if (tasks.isEmpty()){
            return;
        }
        System.out.println("اختر مهمة لتعديل حالتها");
        int a =scanner.nextInt();
        scanner.nextLine();
        int b =a-1;
        if (b >= 0 && b < tasks.size()){
            System.out.println("اختر الحالة الجديد \n 1=> YES \n2=> NO");
            Task t = tasks.get(b);
            int boo = scanner.nextInt();
            if (boo==1) {
                t.bool=true;
            }else if (boo==0) {
                t.bool=false;
            }else{
                System.out.println("اختر 1 او 0 فقط ");
            }

        }else{
            System.out.println("خطا في رقم المهمة");
        }
    }

    public static void displayYEStask(ArrayList<Task> tasks){ //عرض المهام المنجزة
        System.out.println("قائمة المهام الموجودة");
        if (tasks.isEmpty()) {
            System.out.println("لا توجد مهام بعد");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            Task t = tasks.get(i);
            if (t.bool == true) {
                System.out.println((i+1) + "=>" + t.tasks);  
            }
        }
    }
    public static void displayNOtask(ArrayList<Task> tasks){ // عرض المهام الغير منجزة
        System.out.println("قائمة المهام الموجودة");
        if (tasks.isEmpty()) {
            System.out.println("لا توجد مهام بعد");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            Task t = tasks.get(i);
            if (t.bool == false) {
                System.out.println((i+1) + "=>" + t.tasks);  
            }
        }
    }

    public static void delittask(ArrayList<Task> tasks,Scanner scanner){//حذف مهمة
        displaytask(tasks);
        if (tasks.isEmpty()){
            return;
        }
        System.out.println("اختر مهمة لحذفها");
        int a =scanner.nextInt();
        scanner.nextLine();
        int b =a-1;
        if (b >= 0 && b < tasks.size()){
            Task RT = tasks.remove(b);
            System.out.println("تم حذف المهمة =>"+ RT.tasks);
        }else{
            System.out.println("خطا في رقم المهمة");
        }
    }

    public static void displayHelp() {
    System.out.println("\n=====  دليل استخدام برنامج إدارة المهام =====");
    System.out.println("1. إضافة مهمة: تسمح لك بإدخال وصف مهمة جديدة.");
    System.out.println("2. تعديل مهمة: لتغيير نص مهمة معينة باستخدام رقمها.");
    System.out.println("3. حذف مهمة: لإزالة مهمة نهائياً من القائمة.");
    System.out.println("4. تعديل حالة مهمة: لتحديث حالة المهمة (منجزة أو غير منجزة).");
    System.out.println("5. عرض المهام المنجزة: لعرض المهام التي اكتملت فقط.");
    System.out.println("6. عرض المهام الحالية: لعرض المهام التي لا تزال قيد الإنجاز.");
    System.out.println("7. عرض المساعدة: لعرض هذه القائمة الإرشادية.");
    System.out.println("8. حفظ المهام في ملف نصي");
    System.out.println("0. الخروج: لإغلاق التطبيق.");
    System.out.println("===============================================\n");
}

    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== برنامج إدارة المهام TODO =====");
            System.out.println("1. إضافة مهمة");
            System.out.println("2. تعديل مهمة");
            System.out.println("3. حذف مهمة");
            System.out.println("4. تعديل حالة مهمة");
            System.out.println("5. عرض قائمة المهام المنجزة");
            System.out.println("6. عرض قائمة المهام الحالية");
            System.out.println("7. عرض المساعدة والأوامر");
            System.out.println("8. حفض في ملف");
            System.out.println("0. الخروج");
            System.out.print("اختر أمراً: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1:
                    System.out.println("-> اخترت: إضافة مهمة");
                    addtask(tasks,scanner);
                    break;
                case 2:
                    System.out.println("-> اخترت: تعديل مهمة");
                    updatetask(tasks,scanner);
                    break;
                case 3:
                    System.out.println("-> اخترت: حذف مهمة");
                    delittask(tasks, scanner);
                    break;
                case 4:
                    System.out.println("-> اخترت: تعديل حالة مهمة");
                    changetask(tasks,scanner);
                    break;
                case 5:
                    System.out.println("-> اخترت: عرض المهام المنجزة");
                    displayYEStask(tasks);
                    break;
                case 6:
                    System.out.println("-> اخترت: عرض المهام الحالية");
                    displayNOtask(tasks);
                    break;
                case 7:
                    System.out.println("-> اخترت: عرض المساعدة");
                    displayHelp();
                    break;
                case 8:
                    System.out.println("-> اخترت: حفظ المهام في ملف نصي");
                    saveToFile(tasks);
                    break;
                case 0:
                    System.out.println("تم الخروج من البرنامج. إلى اللقاء!");
                    break;
                default:
                    System.out.println("خيار غير صحيح، حاول مرة أخرى.");
            }
        } while (choice != 0);
        scanner.close();
        
    }
}