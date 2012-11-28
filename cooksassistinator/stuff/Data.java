package cooksassistinator.stuff;

import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.map.TilePath;

public interface Data {
	// Areas
	public final Area KITCHEN = new Area(new Tile(3203, 3211, 0), new Tile(
			3213, 3219, 0));
	public final Area LUMBRIDGE_SQUARE = new Area(new Tile(3215, 3203, 0),
			new Tile(3226, 3234, 0));
	public final Area WHEATFIELD = new Area(new Tile[] {
			new Tile(3164, 3291, 0), new Tile(3164, 3300, 0),
			new Tile(3159, 3307, 0), new Tile(3156, 3308, 0),
			new Tile(3154, 3308, 0), new Tile(3153, 3306, 0),
			new Tile(3152, 3297, 0), new Tile(3153, 3296, 0),
			new Tile(3155, 3295, 0), new Tile(3160, 3291, 0) });

	// Paths
	public final TilePath SQUARE_TO_COOK = new TilePath(new Tile[] {
			new Tile(3214, 3218, 0), new Tile(3214, 3213, 0),
			new Tile(3209, 3211, 0), new Tile(3208, 3216, 0) });

	public final TilePath COOK_TO_FENCE = new TilePath(new Tile[] {
			new Tile(3208, 3215, 0), new Tile(3208, 3210, 0),
			new Tile(3211, 3211, 0), new Tile(3215, 3215, 0),
			new Tile(3221, 3219, 0), new Tile(3226, 3219, 0),
			new Tile(3231, 3219, 0), new Tile(3233, 3224, 0),
			new Tile(3238, 3226, 0), new Tile(3243, 3226, 0),
			new Tile(3248, 3226, 0), new Tile(3253, 3227, 0),
			new Tile(3256, 3231, 0), new Tile(3258, 3236, 0),
			new Tile(3257, 3241, 0), new Tile(3255, 3246, 0),
			new Tile(3252, 3250, 0), new Tile(3249, 3254, 0),
			new Tile(3248, 3259, 0), new Tile(3250, 3264, 0),
			new Tile(3251, 3267, 0) });

	public final TilePath FENCE_TO_COW = new TilePath(new Tile[] {
			new Tile(3253, 3268, 0), new Tile(3256, 3269, 0),
			new Tile(3261, 3272, 0), new Tile(3262, 3276, 0) });

	public final TilePath COW_TO_FENCE = new TilePath(new Tile[] {
			new Tile(3262, 3276, 0), new Tile(3261, 3272, 0),
			new Tile(3256, 3269, 0), new Tile(3253, 3268, 0)
	});

	public final TilePath CFENCE_TO_CFENCE = new TilePath(new Tile[] {
			new Tile(3250, 3267, 0), new Tile(3248, 3272, 0),
			new Tile(3245, 3276, 0), new Tile(3241, 3279, 0),
			new Tile(3238, 3284, 0), new Tile(3238, 3289, 0),
			new Tile(3238, 3294, 0), new Tile(3237, 3296, 0) });

	public final TilePath CFENCE_TO_WFENCE = new TilePath(new Tile[] {
			new Tile(3238, 3298, 0), new Tile(3238, 3293, 0),
			new Tile(3238, 3288, 0), new Tile(3239, 3283, 0),
			new Tile(3241, 3278, 0), new Tile(3245, 3275, 0),
			new Tile(3243, 3270, 0), new Tile(3241, 3265, 0),
			new Tile(3237, 3262, 0), new Tile(3232, 3262, 0),
			new Tile(3227, 3261, 0), new Tile(3222, 3261, 0),
			new Tile(3217, 3261, 0), new Tile(3216, 3266, 0),
			new Tile(3214, 3271, 0), new Tile(3212, 3276, 0),
			new Tile(3208, 3279, 0), new Tile(3203, 3279, 0),
			new Tile(3198, 3279, 0), new Tile(3193, 3281, 0),
			new Tile(3189, 3284, 0), new Tile(3184, 3285, 0),
			new Tile(3179, 3286, 0), new Tile(3174, 3287, 0),
			new Tile(3169, 3289, 0), new Tile(3165, 3292, 0),
			new Tile(3166, 3297, 0) });

	public final TilePath MILL_TO_COOK = new TilePath(new Tile[] {
			new Tile(3166, 3301, 0), new Tile(3166, 3296, 0),
			new Tile(3167, 3291, 0), new Tile(3170, 3287, 0),
			new Tile(3175, 3286, 0), new Tile(3180, 3285, 0),
			new Tile(3185, 3283, 0), new Tile(3190, 3283, 0),
			new Tile(3195, 3281, 0), new Tile(3200, 3279, 0),
			new Tile(3205, 3279, 0), new Tile(3210, 3278, 0),
			new Tile(3215, 3277, 0), new Tile(3216, 3272, 0),
			new Tile(3217, 3267, 0), new Tile(3217, 3262, 0),
			new Tile(3217, 3257, 0), new Tile(3218, 3252, 0),
			new Tile(3220, 3247, 0), new Tile(3222, 3242, 0),
			new Tile(3225, 3238, 0), new Tile(3228, 3234, 0),
			new Tile(3230, 3229, 0), new Tile(3234, 3226, 0),
			new Tile(3236, 3221, 0), new Tile(3231, 3219, 0),
			new Tile(3226, 3219, 0), new Tile(3221, 3219, 0),
			new Tile(3216, 3220, 0), new Tile(3215, 3215, 0),
			new Tile(3212, 3211, 0), new Tile(3207, 3211, 0),
			new Tile(3206, 3214, 0) });
}
