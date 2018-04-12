package flyweight;

import java.util.Hashtable;

/**
 * @author coderyong
 * @date 2018/4/10
 */
public class IgoChessmanFactory {

    private static IgoChessmanFactory instance = new IgoChessmanFactory();
    /**
     * 使用Hashtable来存储享元对象，充当享元池
     */
    private static Hashtable ht;

    private IgoChessmanFactory() {
        ht = new Hashtable();
        IgoChessman black, white;
        black = new BlackIgoChessman();
        ht.put("b", black);
        white = new WhiteIgoChessman();
        ht.put("w", white);
    }

    /**
     * 返回享元工厂类的唯一实例
     *
     * @return
     */
    public static IgoChessmanFactory getInstance() {
        return instance;
    }

    /**
     * 通过key来获取存储在Hashtable中的享元对象
     *
     * @param color 颜色
     * @return 棋子对象
     */
    public IgoChessman getIgoChessman(String color) {
        return (IgoChessman) ht.get(color);
    }

}
