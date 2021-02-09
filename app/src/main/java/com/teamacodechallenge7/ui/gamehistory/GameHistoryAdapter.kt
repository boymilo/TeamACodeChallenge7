package com.teamacodechallenge7.ui.gamehistory

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.teamacodechallenge7.R
import com.teamacodechallenge7.data.model.GetBattle
import com.teamacodechallenge7.utils.getStringTimeStampWithDate



@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class GameHistoryAdapter(
    private val arrayList: List<GetBattle.Data>,
    val context: Context
) : RecyclerView.Adapter<GameHistoryAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvDate: TextView = itemView.findViewById(R.id.tvDate)
        var tvMode: TextView = itemView.findViewById(R.id.tvMode)
        var tvResult: TextView = itemView.findViewById(R.id.tvResult)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_skor, parent, false)
        )


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val date = arrayList[position].updatedAt
        date.toSortedSet()
        val resultBattle = arrayList[position].result
        val modeBattle = arrayList[position].mode
        val result = arrayList[position].message


        when (resultBattle) {
            "Opponent Win" -> {
                holder.tvResult.setTextColor(Color.parseColor("#E67A6C"))
            }
            "Draw" -> {
                holder.tvResult.setTextColor(Color.parseColor("#9DABB9"))
            }
            else -> {
                holder.tvResult.setTextColor(Color.parseColor("#A4C1BB"))
            }
        }
        holder.tvMode.text = modeBattle
        holder.tvResult.text = result
        holder.tvDate.text = date.getStringTimeStampWithDate()

    }

    override fun getItemCount(): Int {
        return arrayList.size
    }


}
