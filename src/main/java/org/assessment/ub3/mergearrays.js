function merge(...args) {
    let concatArr = Array.prototype.concat(...args);
    // let concatArr = [].concat(...args);
    concatArr = Array.from(new Set(concatArr));
    return concatArr.sort();
}