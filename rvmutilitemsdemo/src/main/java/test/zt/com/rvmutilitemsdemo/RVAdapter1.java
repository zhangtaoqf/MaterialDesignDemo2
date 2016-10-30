package test.zt.com.rvmutilitemsdemo;

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
 * 1.适配器泛型不用添加
 * 2.重写getItemViewType()
 * 3.去实现实例化ViewHolder，和绑定ViewHolder
 */
public class RVAdapter1 extends RecyclerView.Adapter {
    private static final int BODY2_TYPE = 3;
    private List<String> datas;
    private LayoutInflater inflater;
    public static final int HEAD_TYPE = 0;
    public static final int FOOT_TYPE = 1;
    public static final int BODY_TYPE = 2;

    public RVAdapter1(Context context) {
        this.datas = new ArrayList<>();
        this.inflater = LayoutInflater.from(context);
    }

    private LoadMoreListener loadMoreListener;

    public void setLoadMoreListener(LoadMoreListener loadMoreListener) {
        this.loadMoreListener = loadMoreListener;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType) {
            case HEAD_TYPE:
                view = headerView;
                break;
            case BODY_TYPE:
                view = inflater.inflate(R.layout.item_rv_body, parent, false);
                break;
            case FOOT_TYPE:
                view = footerView;
                break;
        }
        return new ViewHolder(view);
    }
    /**
     * 返回对应位置的item类型
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HEAD_TYPE;
        } else if (position == getItemCount() - 1) {
            return FOOT_TYPE;
        }
        return BODY_TYPE;
    }

    private View headerView;
    private View footerView;

    public void setHeaderView(View headerView) {
        this.headerView = headerView;
    }

    public void setFooterView(View footerView) {
        this.footerView = footerView;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case HEAD_TYPE:
                break;
            case BODY_TYPE:
                ViewHolder viewHolder = (ViewHolder) holder;
                viewHolder.textView.setText(datas.get(position - 1));
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onItemClickListener.onItemClick(v,holder.getLayoutPosition());
                    }
                });
                break;

            case BODY2_TYPE:
                //直接强转直接去使用就OK了
                break;
            case FOOT_TYPE:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000);
                            holder.itemView.post(new Runnable() {
                                @Override
                                public void run() {
                                    loadMoreListener.loadMore();
                                }
                            });
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                break;
        }
    }

    public interface LoadMoreListener {
        public void loadMore();
    }

    @Override
    public int getItemCount() {
        return datas.size() + 2;
    }

    public void addAll(List<String> dd) {
        datas.addAll(dd);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = ((TextView) itemView.findViewById(R.id.item_rv_body_textViewId));
        }
    }
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        public void onItemClick(View view, int position);
    }
}
