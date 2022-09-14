public class TP02Q01{
    public static boolean isFim(String word) {
		if (word.equals("FIM"))
			return false;
		else 
			return true;
	}
    public static void main(String [] args){
        Game game = new Game();
        String id;

        do{
            id = MyIO.readLine();
			try{
                game.ler(id);
                game.imprimir();
            } catch (Exception e){ }
		} while(isFim(id));
    }
}