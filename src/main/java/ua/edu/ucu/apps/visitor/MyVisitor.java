package ua.edu.ucu.apps.visitor;

public class MyVisitor implements Visitor {
    private String groupUUID;
    public MyVisitor(String groupUUID) {
        this.groupUUID = groupUUID;
    }
    public void visit(Task<?> task) {
        task.setHeader("groupUUID", groupUUID);
    }
}
