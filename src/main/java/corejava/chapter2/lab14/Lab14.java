package corejava.chapter2.lab14;

public class Lab14 {
    public static void main(String[] args) {
        Network myFace = new Network();
        Network.Member fred = myFace.enroll("Fred");
        Network.Member alice = myFace.enroll("Alice");
        alice.leave();
        fred.leave();
    }
    /*
    aleksejagnenkov@192 lab14 % javap -p Network
    Warning: File ./Network.class does not contain class Network
    Compiled from "Network.java"
    public class corejava.chapter2.lab14.Network {
        private java.util.List<corejava.chapter2.lab14.Network$Member> members;
        public corejava.chapter2.lab14.Network();
        public corejava.chapter2.lab14.Network$Member enroll(java.lang.String);
    }

    aleksejagnenkov@192 lab14 % javap -p Network\$Member
    Warning: File ./Network$Member.class does not contain class Network$Member
    Compiled from "Network.java"
    public class corejava.chapter2.lab14.Network$Member {
        private java.lang.String name;
        private final java.util.List<corejava.chapter2.lab14.Network$Member> friends;
        final corejava.chapter2.lab14.Network this$0;
        public corejava.chapter2.lab14.Network$Member(corejava.chapter2.lab14.Network, java.lang.String);
        public void leave();
        public boolean belongsTo(corejava.chapter2.lab14.Network);
    }

    */
}
