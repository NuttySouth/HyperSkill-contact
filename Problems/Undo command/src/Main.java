import java.util.LinkedList;

interface Movable {
    int getX();
    int getY();
    void setX(int newX);
    void setY(int newY);
}

interface Storable {
    LinkedList<String> list = new LinkedList<>();
    int getInventoryLength();
    String getInventoryItem(int index);
    void setInventoryItem(int index, String item);
}

interface Command {
    void execute();
    void undo();
}

class CommandMove implements Command {
    Movable entity;
    int xMovement;
    int yMovement;

    public void execute(){
        this.entity.setX(this.entity.getX() + xMovement);
        this.entity.setY(this.entity.getY() + yMovement);
    }

    public void undo(){
        this.entity.setX(this.entity.getX() - xMovement);
        this.entity.setY(this.entity.getY() - yMovement);
    }
}

class CommandPutItem implements Command {
    Storable entity;
    String item;

    public void execute(){
        if(entity.list.size() == 0){
            entity.list.add(item);
        }else{
            entity.list.addLast(item);
        }
    }

    public void undo(){
        entity.list.removeLast();
    }
}