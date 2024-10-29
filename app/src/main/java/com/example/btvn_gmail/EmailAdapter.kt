// File: app/src/main/java/com/example/btvn_gmail/EmailAdapter.kt

package com.example.btvn_gmail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class Email(val sender: String, val subject: String, val snippet: String, val time: String)

class EmailAdapter(private val emails: List<Email>) : RecyclerView.Adapter<EmailAdapter.EmailViewHolder>() {

    class EmailViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val avatarImageView: ImageView = view.findViewById(R.id.email_avatar)
        val senderTextView: TextView = view.findViewById(R.id.email_sender)
        val subjectTextView: TextView = view.findViewById(R.id.email_subject)
        val snippetTextView: TextView = view.findViewById(R.id.email_snippet)
        val timeTextView: TextView = view.findViewById(R.id.email_time)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.email_item, parent, false)
        return EmailViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        val email = emails[position]
        holder.senderTextView.text = email.sender
        holder.subjectTextView.text = email.subject
        holder.snippetTextView.text = email.snippet
        holder.timeTextView.text = email.time
        // Set avatar image if available
        holder.avatarImageView.setImageResource(R.drawable.ic_avatar_placeholder)
    }

    override fun getItemCount() = emails.size
}