package com.sharesofa.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 *
 * Parcelable 效率更高，
 *  a、在使用内存的时候，Parcelable比Serializable性能高，所以推荐使用Parcelable类。
 *  b、Serializable在序列化的时候会产生大量的临时变量，从而引起频繁的GC。
 *  c、持久化存储适合用Serializable
 *
 * @see  <http://www.cnblogs.com/trinea/archive/2012/11/09/2763213.html/>
 *
 */
public class ExBean  implements Parcelable {



    @Override public int describeContents() {
        return 0;
    }

    @Override public void writeToParcel(Parcel dest, int flags) {


    }
}
