package corejava.chapter4.additional;

import corejava.chapter4.additional.message.IAmHere;
import corejava.chapter4.additional.message.Message;
import corejava.chapter4.additional.operation.Mult;
import corejava.chapter4.additional.operation.Operation;

public class Task {
    public static void main(String[] args) {
        try {
            DIServiceLoader<Message> messageDI = DIServiceLoader.load(Message.class);
            System.out.println(messageDI.getBean("S2").getMessage());
            System.out.println(messageDI.getBean("S2").getMessage());
            System.out.println(messageDI.getBean("S2").getMessage());
            System.out.println(messageDI.getBean(IAmHere.class).getMessage());

            DIServiceLoader<Operation> operationDI = DIServiceLoader.load(Operation.class);
            System.out.println(operationDI.getBean("+").getOperation(3, 5));
            System.out.println(operationDI.getBean("+").getOperation(3, 5));
            System.out.println(operationDI.getBean("*").getOperation(3, 5));
            System.out.println(operationDI.getBean(Mult.class).getOperation(3, 5));
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
