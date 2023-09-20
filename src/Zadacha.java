public class Zadacha {
    private String name;
    private boolean status;
    private Ispolnitel ispolnitel;

    public Zadacha(String name){
        this.name = name;
    }

    public void setStatus(){
        this.status = true;
    }

    public void setIspolnitel(Ispolnitel ispolnitel){
        this.ispolnitel = ispolnitel;
    }

    public void Vivod(){
        System.out.println("Название: " + name + "\nСтатус задачи: " + status);
        try{
            System.out.println("Исполнитель: ");
            ispolnitel.Vivod();
        }
        catch (Exception exception){
            System.out.println("Нет исполнителя.");
        }
    }
}
