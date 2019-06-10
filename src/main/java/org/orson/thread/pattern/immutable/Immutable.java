package org.orson.thread.pattern.immutable;

public class Immutable {


    public static void main(String[] args) {


        ImmutableResource resource = new ImmutableResource(5);


        for(int i = 0; i< 10; i++) {
            new Thread(new ImmutableThread(resource)).start();
        }


    }
}


class ImmutableResource {
    private final Integer count;

    public ImmutableResource(Integer count) {
        this.count = count;
    }

    public void display() {
        System.out.println(this.count);
    }
}

class ImmutableThread implements Runnable {
    ImmutableResource resource;

    public ImmutableThread(ImmutableResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for(int i = 0; i < 3; i++) {
            resource.display();
        }
    }
}
