package test.zt.com.materialdesigndemo2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/27.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {

    private List<String> datas;
    private LayoutInflater inflater;

    public RVAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
        this.datas = new ArrayList<>();
    }

    /**
     * 实例化ViewHolder
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_rv,parent,false));
    }

    /**
     * 绑定数据
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(datas.get(position));
    }

    /**
     * 指定itemView的条目数
     * @return
     */
    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void addAll(List<String> dd) {
        datas.addAll(dd);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = ((TextView) itemView.findViewById(R.id.item_rv_textViewId));
        }
    }
}
