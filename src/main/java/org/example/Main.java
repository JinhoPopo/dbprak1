package org.example;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{
        Repos<Cliets> clietsRepos = new ClietsRepos();
        Repos<Masters> masterRepos = new MasterRepos();

        List<Cliets> cliets = clietsRepos.getList();
        List<Masters> masters = masterRepos.getList();
        for (Cliets cliet : cliets){
            DBW.printCliet(cliet);
        }
        for (Masters master : masters){
            DBW.printMaster(master);
        }
        for (Cliets cliet : cliets) {
            DBW.printClietMaster(cliet);

        }
    }
}
