package com.example.androidnavigation;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Popup menu demo
        Button popupMenuBtn = findViewById(R.id.popupMenuBtn);
        popupMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getApplicationContext(), v);
                popupMenu.inflate(R.menu.popup_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        final int itemId = item.getItemId();
                        if (itemId == R.id.popup_menu_share) {
                            showToast("Share");
                        } else if (itemId == R.id.popup_menu_reply) {
                            showToast("Reply");
                        } else if (itemId == R.id.popup_menu_forward) {
                            showToast("Forward");
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });

        // register context menu
        TextView contextMenuToggler = findViewById(R.id.contextMenuToggler);
        registerForContextMenu(contextMenuToggler);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.opt_menu_file_save) {
            showToast("Save clicked");
        } else if (item.getItemId() == R.id.opt_menu_file_save_as) {
            showToast("Save as clicked");
        } else if (item.getItemId() == R.id.opt_menu_edit) {
            showToast("Edit option clicked");
        } else if (item.getItemId() == R.id.opt_menu_view) {
            showToast("View option clicked");
        } else if (item.getItemId() == R.id.opt_menu_logout) {
            showToast("Bye!");
            return false;
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        final int itemId = item.getItemId();
        if (itemId == R.id.popup_menu_share) {
            showToast("Share");
        } else if (itemId == R.id.popup_menu_reply) {
            showToast("Reply");
        } else if (itemId == R.id.popup_menu_forward) {
            showToast("Forward");
        }
        return true;
    }

    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}