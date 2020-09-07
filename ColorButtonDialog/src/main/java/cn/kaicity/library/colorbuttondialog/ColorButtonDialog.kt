package cn.kaicity.library.colorbuttondialog

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.viewbinding.ViewBinding
import cn.kaicity.library.colorbuttondialog.databinding.DialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class ColorButtonDialog(private val context: Context) {


    private var title: String? = null

    private var message: String? = null

    private var positiveButtonText: String? = null

    private var positiveButtonListener: ((button: Button) -> Unit)? = null

    private var negativeButtonText: String? = null

    private var negativeButtonListener: ((button: Button) -> Unit)? = null

    private var iconViewId: Int? = null

    private var contentView: View? = null

    fun setTitle(title: String) {

        this.title = title
    }

    fun setIcon(id: Int) {
        this.iconViewId = id
    }

    fun setMessage(message: String) {
        this.message = message
    }

    fun setView(view: View) {
        this.contentView = view
    }
    fun setView(id: Int) {
        this.contentView = View.inflate(context,id,null)
    }

    fun setOnPositiveButton(text: String, onclick: ((button: Button) -> Unit)? = null) {
        this.positiveButtonText = text
        this.positiveButtonListener = onclick
    }

    fun setOnNegativeButton(text: String, onclick: ((button: Button) -> Unit)? = null) {
        this.negativeButtonText = text
        this.negativeButtonListener = onclick
    }


    fun show(): BottomSheetDialog {
        val viewBinding: DialogBinding = DialogBinding.inflate(LayoutInflater.from(context))
        val dialog = BottomSheetDialog(context)
        if (title != null) {
            viewBinding.title.text = title
            viewBinding.title.visibility = View.VISIBLE
        } else {
            viewBinding.title.visibility = View.GONE
        }

        if (contentView != null) {
            viewBinding.root.addView(contentView)

        } else if (message != null) {
            val textView = TextView(context)
            textView.text = message
            viewBinding.root.addView(textView)
        }

        if (positiveButtonText != null) {
            viewBinding.positiveButton.text = positiveButtonText
            viewBinding.positiveButton.setOnClickListener {
                if (positiveButtonListener != null) {
                    positiveButtonListener!!(viewBinding.positiveButton)
                }
                dialog.dismiss()
            }
        } else {
            viewBinding.positiveButton.visibility = View.GONE
        }

        if (negativeButtonText != null) {
            viewBinding.negativeButton.text = negativeButtonText
            viewBinding.negativeButton.setOnClickListener {
                if (negativeButtonListener != null) {
                    negativeButtonListener!!(viewBinding.negativeButton)
                }
                dialog.dismiss()
            }
        } else {
            viewBinding.negativeButton.visibility = View.GONE
        }

        if(iconViewId!=null){
            viewBinding.icon.setImageResource(iconViewId!!)
        }else{
            viewBinding.icon.visibility=View.GONE
        }


        dialog.setContentView(viewBinding.root)
        dialog.show()

        return dialog
    }

}