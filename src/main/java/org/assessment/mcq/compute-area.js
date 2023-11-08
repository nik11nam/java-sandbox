// https://gist.github.com/Kaeyz/4ca3d77da72aa6c3bdfe165795f53147
// https://gist.github.com/jdnichollsc/3ba81f4409f8031d39951dcd96f0900a
const getArea = (shape, values) => {
    let area = -1
    switch(shape) {
        case "square":
            area = Math.pow(values[0], 2);
            break;
        case "rectangle":
            area = values[0] * values[1];
            break;
        case "circle":
            area = 3.14 * Math.pow(values[0], 2);
            break;
        case "triangle":
            area = 0.5 * values[0] * values[1];
            break;
        default:
            break;
    }
    return area;
}

// Complete the calculateArea function below.
// It returns a Promise which on success, returns area of the shape, and on failure returns [-1].
let calculateArea = async (shape, values) => {
    const area = getArea(shape, values)
    if (area == -1) {
        throw new Error(-1)
    }
    else{
        return Math.floor(area * 100) / 100
    }
}

// Complete the generateArea function below.
// It returns a Promise which on success, returns an array of areas of all the shapes and on failure, returns [-1].
let getAreas = async (shapes, values_arr) => {
    try {
        const areas = await Promise.all(
        shapes.map((shape, index) => calculateArea(shape, values_arr[index]))
        )
        return areas;
    }
    catch {
        return [-1]
    }
}