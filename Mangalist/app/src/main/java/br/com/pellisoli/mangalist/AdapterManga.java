package br.com.pellisoli.mangalist;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.InputStream;
import java.util.List;

public class AdapterManga extends BaseAdapter {


    private List<Manga> mangaList;
    private Context context;
    private LayoutInflater inflater;

    public AdapterManga(Context context, List<Manga> mangaList){
        this.mangaList = mangaList;
        this.context = context;
        this.inflater = LayoutInflater.from( context );
    }

    @Override
    public int getCount() {
        return mangaList.size();
    }

    @Override
    public Object getItem(int i) {
        return mangaList.get( i );
    }

    @Override
    public long getItemId(int i) {
        return mangaList.get(i).getId();
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ItemSuporte item;

        if( convertView == null){
            convertView = inflater.inflate(R.layout.fragment_item_list, null);

            item = new ItemSuporte();
            item.tvTitulo = convertView.findViewById(R.id.tvlistaTitulo);
            item.tvLinkImg = convertView.findViewById(R.id.tvlistaImg);
            item.tvLinkManga = convertView.findViewById(R.id.form_link_titulo);
            item.tvUtCAP = convertView.findViewById(R.id.form_ultimo_cap);
            item.layout = convertView.findViewById(R.id.llFundoLista);
            convertView.setTag( item );
        }else {
            item = (ItemSuporte) convertView.getTag();
        }

        Manga manga = mangaList.get(i);
        item.tvTitulo.setText(  manga.getTitulo() );
        new DownloadImageTask((ImageView) item.tvLinkImg).execute(manga.getLinkImg());
        item.tvUtCAP.setText(  String.valueOf( manga.getUltimoCap()));
        item.tvLinkManga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(manga.getLinkTitulo());
                Intent intent= new Intent(Intent.ACTION_VIEW,uri);
                context.startActivity(intent);
            }
        });
        if( i % 2 == 0 ){
            item.layout.setBackgroundColor(Color.rgb(230, 230, 230));
        }else {
            item.layout.setBackgroundColor( Color.WHITE );
        }
        return convertView;
    }
    private class ItemSuporte{
        TextView tvTitulo, tvUtCAP;
        ImageView  tvLinkImg;
        Button tvLinkManga;
        LinearLayout layout;
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}
