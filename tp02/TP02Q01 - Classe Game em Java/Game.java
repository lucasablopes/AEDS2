import java.util.Arrays;
import java.io.*;
import java.text.DecimalFormat;

class Game{
    private int app_id;
    private String name;
    private String release_date;
    private String owners;
    private int age;
    private float price;
    private int dlcs;
    private String[] languages;
    private String website;
    private boolean windows;
    private boolean mac;
    private boolean linux;
    private float upvotes;
    private int avg_pt;
    private String developers;
    private String[] generes;

    public Game(){}
    
    public Game(int app_id,String name,String release_date,String owners,int age, float price, int dlcs, String[] languages, String website,
    boolean windows, boolean mac, boolean linux, float upvotes, int avg_pt, String developers, String[] generes){
        this.app_id = app_id;
        this.name = name;
        this.release_date = release_date;
        this.owners = owners;
        this.age = age;
        this.price = price;
        this.dlcs = dlcs;
        this.languages = languages;
        this.website = website;
        this.windows = windows;
        this.mac = mac;
        this.linux = linux;
        this.upvotes = upvotes;
        this.avg_pt = avg_pt;
        this.developers = developers;
        this.generes = generes;
    }

    public int getApp_id(){
        return app_id;
    }

    public void setApp_id(int app_id){
        this.app_id = app_id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getRelease_date(){
        return release_date;
    }

    public void setRelease_date(String release_date){
        this.release_date = release_date;
    }

    public String getOwners(){
        return owners;
    }

    public void setOwners(String owners){
        this.owners = owners;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public float getPrice(){
        return price;
    }

    public void setPrice(float price){
        this.price = price;
    }

    public int getDlcs(){
        return dlcs;
    }

    public void setDlcs(int dlcs){
        this.dlcs = dlcs;
    }

    public String[] getLanguages(){
        return languages;
    }

    public void setLanguages(String[] languages){
        this.languages = languages;
    }

    public String getWebsite(){
        return website;
    }

    public void setWebsite(String website){
        this.website = website;
    }

    public boolean isWindows(){
        return windows;
    }

    public void setWindows(boolean windows){
        this.windows = windows;
    }

    public boolean isMac(){
        return mac;
    }

    public void setMac(boolean mac){
        this.mac = mac;
    }

    public boolean isLinux(){
        return linux;
    }

    public void setLinux(boolean linux){
        this.linux = linux;
    }

    public float getUpvotes(){
        return upvotes;
    }

    public void setUpvotes(float upvotes){
        this.upvotes = upvotes;
    }

    public int getAvg_pt(){
        return avg_pt;
    }

    public void setAvg_pt(int avg_pt){
        this.avg_pt = avg_pt;
    }

    public String getDevelopers(){
        return developers;
    }

    public void setDevelopers(String developers){
        this.developers = developers;
    }

    public String[] getGeneres(){
        return generes;
    }

    public void setGeneres(String[] generes){
        this.generes = generes;
    }

    public Game Clone(){
        Game cloned = new Game();

        cloned.app_id = this.app_id;
        cloned.name = this.name;
        cloned.release_date = this.release_date;
        cloned.owners = this.owners;
        cloned.age = this.age;
        cloned.price = this.price;
        cloned.dlcs = this.dlcs;
        cloned.languages = this.languages;
        cloned.website = this.website;
        cloned.windows = this.windows;
        cloned.mac = this.mac;
        cloned.linux = this.linux;
        cloned.upvotes = this.upvotes;
        cloned.avg_pt = this.avg_pt;
        cloned.developers = this.developers;
        cloned.generes = this.generes;

        return cloned;
    }

    public void imprimir(){
        String roundedUpv = new java.text.DecimalFormat("0").format(upvotes);
        
        DecimalFormat dfrmt = new DecimalFormat("#.##");
        dfrmt.setMinimumFractionDigits(2);

        if(price == 0) {
            System.out.println(app_id + " " + name + " " + release_date + " " + owners + " " + age + " " + "0.00" + " " + dlcs +
            " " + Arrays.toString(languages) + " " + website + " " + windows + " "+ mac + " " + linux + " " + roundedUpv +
            "% " + toHoras(avg_pt) + " " + developers + " " + Arrays.toString(generes));
        } else {
            System.out.println(app_id + " " + name + " " + release_date + " " + owners + " " + age + " " + dfrmt.format(price) + " " + dlcs +
            " " + Arrays.toString(languages) + " " + website + " " + windows + " "+ mac + " " + linux + " " + roundedUpv +
            "% " + toHoras(avg_pt) + " " + developers + " " + Arrays.toString(generes));
        }
    }

    public boolean isID(String id, String line) {
        boolean boo = false;
        String aux = "";

        for(int i=0; line.charAt(i) != ','; i++)
            aux += line.charAt(i);

        if(Integer.parseInt(aux)  == Integer.parseInt(id)) 
            boo = true;
        
        return boo;
    }

    public String removeQuotes(String token){
        String aux = "";
        for(int i=0; i<token.length(); i++) {
            if(token.charAt(i) != '\"' && token.charAt(i) != '\'' && token.charAt(i) != '[' && token.charAt(i) != ']')
                aux += token.charAt(i);
        }
        return aux;
    }

    public String toDate(String token){
        String aux = "";
        for(int i=0; i<3; i++)
            aux += token.charAt(i);
        aux += '/';
        for(int i=0; i<token.length(); i++)
            if(i > 6)
                aux += token.charAt(i);

        String aux2 = "";

        for(int i=0; i<aux.length(); i++)
            if(aux.charAt(i) != ' ')
                aux2 += aux.charAt(i);

        return aux2;
    }

    public String toHoras(int avg_pt){
        String aux;

        if(avg_pt != 0){
            int hr, min;
        
            hr = avg_pt/60;
            min = avg_pt%60;

            if(hr != 0 && min == 0)
                aux = hr + "h";
            else if(hr == 0 && min != 0)
                aux = min + "m";
            else
                aux = hr + "h " + min + "m";

        } else {
            aux = "null";
        }


        return aux;
    }

    public void ler(String id) throws Exception{
        InputStreamReader isr = new InputStreamReader(new FileInputStream("tmp/games.csv"));
        BufferedReader br = new BufferedReader(isr);

        String aux;
        String line = br.readLine();

        while(!(isID(id, line)))
            line = br.readLine();

        String[] token = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

        setApp_id(Integer.parseInt(token[0]));
        setName(token[1]);

        aux = toDate(removeQuotes(token[2]));
        setRelease_date(aux);

        setOwners(token[3]);
        setAge(Integer.parseInt(token[4]));
        setPrice(Float.parseFloat(token[5]));
        setDlcs(Integer.parseInt(token[6]));

        aux = removeQuotes(token[7]);
        setLanguages(aux.split(", "));

        if(!(token[8].contains("h")))
            token[8] = "null";
        setWebsite(token[8]);

        for(int i=9; i<12; i++){
            if(token[i].contains("True"))
                token[i] = "true";
            else if(token[i].contains("False"))
                token[i] = "false";
        }

        setWindows(Boolean.parseBoolean(token[9]));
        setMac(Boolean.parseBoolean(token[10]));
        setLinux(Boolean.parseBoolean(token[11]));

        float up1 = Float.parseFloat(token[12]);
        float up2 = Float.parseFloat(token[13]);
        setUpvotes((100*up1)/(up1+up2));
        
        setAvg_pt(Integer.parseInt(token[14]));
        setDevelopers(removeQuotes(token[15]));

        aux = removeQuotes(token[16]);
        setGeneres(aux.split(","));

        br.close();
    }
}