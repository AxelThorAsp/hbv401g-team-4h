package hi.is.hbv401gteam4h.util;

import java.util.Date;

public class Util {
    public static boolean between(Date date, Date lo, Date hi) {
        return !(date.before(lo) || date.after(hi));
    }
}
