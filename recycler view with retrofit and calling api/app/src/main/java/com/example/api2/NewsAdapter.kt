package com.example.api2

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.api2.databinding.ArticlesListItemBinding

class NewsAdapter(private val activity: Activity, private val articles: ArrayList<Article>) :
    RecyclerView.Adapter<NewsAdapter.NewsHolder>() {

    class NewsHolder(val binding: ArticlesListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val binding = ArticlesListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsHolder(binding)
    }

    override fun getItemCount() = articles.size

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        val article = articles[position]
        holder.binding.articlesText.text = article.title

        Glide.with(holder.binding.articleImage.context)
            .load(article.urlToImage)
            .error(R.drawable.broken_image)
            .into(holder.binding.articleImage)

        holder.binding.articleContainer.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, article.url.toUri())
            activity.startActivity(intent)
        }

        holder.binding.shareFab.setOnClickListener {
            ShareCompat.IntentBuilder(activity)
                .setType("text/plain")
                .setChooserTitle("Share article with:")
                .setText(article.url)
                .startChooser()
        }
    }
}
