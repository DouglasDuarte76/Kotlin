import com.bumptech.glide.Glide

class AcaiAdapter(private val products: List<AcaiProduct>) :
    RecyclerView.Adapter<AcaiAdapter.AcaiViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AcaiViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_acai, parent, false)
        return AcaiViewHolder(view)
    }

    override fun onBindViewHolder(holder: AcaiViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int = products.size

    class AcaiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val productImageView: ImageView = itemView.findViewById(R.id.productImage)

        fun bind(product: AcaiProduct) {
            // Usando Glide para carregar a imagem do produto
            Glide.with(itemView.context)
                .load(product.imageUrl)
                .into(productImageView)
        }
    }
}
