package komtek.Config;

import komtek.Wrapper;

import java.io.File;

public class Config {

    private String name;
    private File file;

    public Config(String name) {
        this.name = name;
        this.file = new File("");
    }
}
