package net.minecraft.src;

public final class ThreadDedicatedServer extends Thread
{
    final DedicatedServer field_96244_a;

    public ThreadDedicatedServer(DedicatedServer par1DedicatedServer)
    {
        this.field_96244_a = par1DedicatedServer;
    }

    public void run()
    {
        this.field_96244_a.stopServer();
    }
}
