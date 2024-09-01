package borknbeans.lightweightinventorysorting.config;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public enum SortTypes {
    ALPHANUMERIC,
    REVERSE_ALPHANUMERIC,
    INVENTORY;

    public int compare(ItemStack left, ItemStack right) {
        switch (this) {
            case ALPHANUMERIC:
                return alphanumeric(left, right);
            case REVERSE_ALPHANUMERIC:
                return reverseAlphanumeric(left, right);
			case INVENTORY:
                return inventory(left, right);
        }

        return 0;
    }

    private int alphanumeric(ItemStack left, ItemStack right) {
        if (left.isEmpty() && !right.isEmpty()) {
            return 0;
        } else if (right.isEmpty() && !left.isEmpty()) {
            return -1;
        }

        return (left.getName().getString().compareTo(right.getName().getString()));
    }

    private int reverseAlphanumeric(ItemStack left, ItemStack right) {
        if (left.isEmpty() && !right.isEmpty()) {
            return 0;
        } else if (right.isEmpty() && !left.isEmpty()) {
            return -1;
        }

        return (left.getName().getString().compareTo(right.getName().getString())) * -1;
    }

    private int inventory(ItemStack left, ItemStack right) {
        if (left.isEmpty() && !right.isEmpty()) {
            return 0;
        } else if (right.isEmpty() && !left.isEmpty()) {
            return -1;
        }

        return Integer.compare(Item.getRawId(left.getItem()), Item.getRawId(right.getItem()));
    }
}
