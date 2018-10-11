package com.ladyishenlong.rl.center.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import com.ladyishenlong.rl.center.annotation.Layout

abstract class BaseRecyAdapter<T>(context: Context, datas: List<T>?) : RecyclerView.Adapter<BaseViewHolder>() {


    protected var datas: List<T>?
    protected var context: Context
    protected var layoutId: Int

    init {
        this.datas = datas
        this.context = context
        this.layoutId = -1
        setLayout()
    }


    private fun setLayout() {
        val clazz = this.javaClass
        if (clazz.getAnnotations() != null) {
            if (clazz.isAnnotationPresent(Layout::class.java)) {
                val layout = clazz.getAnnotation(Layout::class.java)
                if (layout.value != -1) {
                    layoutId = layout.value
                }
            }
        }


        if (layoutId == -1) {
            Throwable("RecyclerView 传入的layoutId 不能为 -1")
            return
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val viewHolder: BaseViewHolder = BaseViewHolder(inflater.inflate(layoutId, parent, false))
        return viewHolder
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val itemView: View = holder.getItemView()
        ButterKnife.bind(this, itemView)
        bindData(datas!![position], position)
    }


    protected abstract fun bindData(data: T, position: Int)


    /**
     * 刷新数据
     *
     * @param datas
     */
    fun setDataSource(datas: List<T>) {
        this.datas = datas
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int = if (datas == null) 0 else datas!!.size

}