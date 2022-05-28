package corejava.chapter2.lab14;

import java.util.ArrayList;
import java.util.List;

public class Network {

    public class Member {
        // Класс Member является внутренним для класса Network
        private final String name;
        private final List<Member> friends;

        public Member(String name) {
            this.name = name;
            friends = new ArrayList<>();
        }

        public void leave() {
            Network.this.members.remove(this);
        }

        public boolean belongsTo(Network n) {
            return Network.this == n;
        }
    }

    private List<Member> members;

    public Network() {
        this.members = new ArrayList<>();
    }

    public Member enroll(String name) {
        Member newMember = this.new Member(name);
        members.add(newMember);
        return newMember;
    }
}

